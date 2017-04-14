package com.ptirador.concessionaire.model;

import com.ptirador.concessionaire.util.Constants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

/**
 * Bean that represents a menu.
 *
 * @author ptirador
 */
@Document(collection = "menus")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Unique id.
     */
    @Id
    private String id;

    /**
     * Parent id.
     */
    private String parentId;

    /**
     * Position number.
     */
    private Integer order;

    /**
     * Access URL.
     */
    private String url;

    /**
     * Alternative text.
     */
    private String alt;

    /**
     * Description text.
     */
    private String text;

    /**
     * Font awesome icon.
     */
    private String icon;

    /**
     * Menu type:
     * General menu: {@link Constants#MENU_GENERAL_ID}
     * Admin menu: {@link Constants#MENU_ADMIN_ID}
     */
    private Integer typeId;

    /**
     * Menu children.
     */
    @DBRef
    private transient List<Menu> children;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}
