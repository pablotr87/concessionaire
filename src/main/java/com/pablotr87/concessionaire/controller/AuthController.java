package com.pablotr87.concessionaire.controller;

import com.pablotr87.concessionaire.model.UserBean;
import com.pablotr87.concessionaire.service.UserService;
import com.pablotr87.concessionaire.util.Constants;
import com.pablotr87.concessionaire.validator.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * App login/signup controller.
 *
 * @author pablotr87
 */
@Controller
public class AuthController {

  /**
   * Logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

  /**
   * View names.
   */
  private static final String VIEW_LOGIN = "loginView";
  private static final String VIEW_SIGN_UP = "signUpView";
  private static final String VIEW_HOME = "carsListView";

  /**
   * URL names.
   */
  private static final String URL_ROOT = "/";
  private static final String URL_LOGIN = "/login";
  private static final String URL_SIGN_UP = "/signup";
  private static final String URL_HOME = "/home";

  /**
   * Model attribute names.
   */
  private static final String MDL_USER = "user";
  /**
   * Error messages.
   */
  private static final String MSG_SIGNUP_KO = "signUp.result.ko";
  private static final String MSG_BAD_CREDENTIALS = "signIn.badCredentials.result.ko";
  private static final String MSG_CREDENTIALS_EXPIRED = "signIn.credentialsExpired.result.ko";

  /**
   * Autowired elements.
   */
  private final UserService userService;
  private final UserValidator userValidator;
  private final PasswordEncoder passwordEncoder;

  /**
   * Autowired constructor.
   * @param userServiceNew
   * @param userValidatorNew
   * @param passwordEncoderNew
   */
  public AuthController(final UserService userServiceNew,
      final UserValidator userValidatorNew,
      final PasswordEncoder passwordEncoderNew) {
    this.userService = userServiceNew;
    this.userValidator = userValidatorNew;
    this.passwordEncoder = passwordEncoderNew;
  }

  /**
   * Mapping for root page.
   *
   * @return Redirection to login page.
   */
  @GetMapping(URL_ROOT)
  public String getRoot() {
    return Constants.REDIRECT + URL_LOGIN;
  }

  /**
   * Mapping for returning login page.
   *
   * @param errorCode Error code for login.
   * @param model Model object.
   * @return Login page.
   */
  @GetMapping(URL_LOGIN)
  public String getLogin(@RequestParam(value = "error", required = false) final String errorCode,
      final Model model) {
    String page = VIEW_LOGIN;

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth instanceof AnonymousAuthenticationToken) {
      model.addAttribute(MDL_USER, new UserBean());
      checkErrorCode(errorCode, model);
    } else {
      page = Constants.REDIRECT + URL_HOME;
    }

    return page;
  }

  /**
   * Error code checking from login page.
   *
   * @param errorCode Error code.
   * @param model Form model.
   */
  private void checkErrorCode(final String errorCode, final Model model) {
    if (null != errorCode) {
      switch (errorCode) {
        case Constants.LOGIN_ERROR_BAD_CREDENTIALS:
          model.addAttribute(Constants.MSG_ERROR, MSG_BAD_CREDENTIALS);
          break;
        case Constants.LOGIN_ERROR_CREDENTIALS_EXPIRED:
          model.addAttribute(Constants.MSG_ERROR, MSG_CREDENTIALS_EXPIRED);
          break;
        default:
          LOG.error("Invalid error code: " + errorCode);
      }
    }
  }

  /**
   * Mapping for returning sign up page.
   *
   * @param model Model object.
   * @return Sign ip page.
   */
  @GetMapping(URL_SIGN_UP)
  public String getSignUp(final Model model) {
    String page = VIEW_SIGN_UP;

    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth instanceof AnonymousAuthenticationToken) {
      model.addAttribute(MDL_USER, new UserBean());
    } else {
      page = Constants.REDIRECT + URL_HOME;
    }

    return page;
  }

  /**
   *
   * @param user
   * @param errors
   * @param model
   * @return
   */
  @PostMapping(URL_SIGN_UP)
  public String postSignUp(@ModelAttribute(MDL_USER) final UserBean user,
      final Errors errors,
      final Model model) {
    String resultPage = VIEW_SIGN_UP;

    userValidator.validate(user, errors);

    if (errors.hasErrors()) {
      LOG.error("Error while registering a user: " + user);
    } else {
      // Password encryption
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      boolean resultOk = userService.insertUser(user) > 0;
      if (resultOk) {
        resultPage = Constants.REDIRECT + VIEW_HOME;
      } else {
        model.addAttribute(Constants.MSG_ERROR, MSG_SIGNUP_KO);
      }
    }

    return resultPage;
  }
}