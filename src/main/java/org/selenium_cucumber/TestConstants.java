package org.selenium_cucumber;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * @author szucs-gabor-92 - 2024
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestConstants {

    /**
     * Test URLs
     */
    public static final String BASE_URL = "https://the-internet.herokuapp.com/";
    public static final String ADD_REMOVE_ELEMENTS_URL = "https://the-internet.herokuapp.com/add_remove_elements/";
    public static final String CHECKBOXES_URL = "https://the-internet.herokuapp.com/checkboxes";
    public static final String CONTEXT_MENU_URL = "https://the-internet.herokuapp.com/context_menu";
    public static final String LOGIN_URL = "https://the-internet.herokuapp.com/login";
    public static final String LOGIN_SUCCESS_URL = "https://the-internet.herokuapp.com/secure";
    public static final String SHADOW_DOM_URL = "https://the-internet.herokuapp.com/shadowdom";

    /**
     * Test utility variables
     */
    public static final int WAIT_INTERVAL_IN_SECONDS = 20;
    public static final int TOTAL_RETRY_COUNT = 5;

    /**
     * UI texts
     */
    public static final String CONTEXT_MENU_ALERT_TEXT = "You selected a context menu";
    public static final String LOGIN_SECURE_AREA_TEXT = "Welcome to the Secure Area. When you are done click logout below.";
    public static final String LOGIN_TEXT = "You logged into a secure area!\n×";
    public static final String LOGOUT_TEXT = "You logged out of the secure area!\n×";
    public static final String SHADOW_DOM_FIRST_PARAGRAPH_SHADOW = "My default text";
    public static final String SHADOW_DOM_SECOND_PARAGRAPH_SHADOW = "My default text";
    public static final String SHADOW_DOM_FIRST_PARAGRAPH = "Let's have some different text!";
    public static final String SHADOW_DOM_SECOND_PARAGRAPH = "FAIL Let's have some different text!\nIn a list!";
}