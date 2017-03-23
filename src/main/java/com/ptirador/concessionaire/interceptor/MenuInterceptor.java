package com.ptirador.concessionaire.interceptor;

import com.ptirador.concessionaire.model.MenuWrapper;
import com.ptirador.concessionaire.model.UserBean;
import com.ptirador.concessionaire.service.MenuService;
import com.ptirador.concessionaire.util.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Set the necessary values to get the menu.
 *
 * @author ptirador
 */
@Component
public class MenuInterceptor extends HandlerInterceptorAdapter {

    /**
     * Session attribute for a list of menus.
     */
    private static final String S_MENUS_LIST = "menusList";

    /**
     * Session attribute for a menu.
     */
    private static final String S_MENU = "menu";
    /**
     * Service for menu management.
     */
    private final MenuService menuService;

    /**
     * Constructor.
     *
     * @param menuService Service for menu management.
     */
    public MenuInterceptor(final MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * It executes before the controller and gets the menu.
     *
     * @param request  HTTP request.
     * @param response HTTP response.
     * @param handler  Handler object.
     * @return
     * @throws ServletException If anything goes wrong.
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws ServletException {

        HttpSession session = request.getSession();
        if (null != session) {
            UserBean sessionUser = (UserBean) session.getAttribute(Constants.USER_LOGIN);
            if (null != sessionUser) {
                @SuppressWarnings("unchecked")
                List<MenuWrapper> menusList = (List<MenuWrapper>) session.getAttribute(S_MENUS_LIST);

                // If it is the first time I access, I get the Map with the 2 possible types.
                if (menusList == null) {
                    int roleId = sessionUser.getRole();
                    menusList = menuService.getMenusList(roleId);
                    session.setAttribute(S_MENUS_LIST, menusList);
                }

                String path = request.getRequestURL().toString();

                if (path.contains("/administration")) {
                    session.setAttribute(S_MENU, getMenusByType(menusList, Constants.MENU_ADMIN_ID));
                } else {
                    session.setAttribute(S_MENU, getMenusByType(menusList, Constants.MENU_GENERAL_ID));
                }

            }
        }
        return true;
    }

    /**
     * @param menuWrapperList
     * @param typeId
     * @return
     */
    private MenuWrapper getMenusByType(List<MenuWrapper> menuWrapperList, Integer typeId) {
        for (MenuWrapper menuWrapper : menuWrapperList) {
            if (typeId.equals(menuWrapper.getTypeId())) {
                return menuWrapper;
            }
        }

        return null;
    }

}
