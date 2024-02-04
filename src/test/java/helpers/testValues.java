package helpers;

import java.util.Arrays;
import java.util.List;

public class testValues {

    /*A/B Testing values*/
    final public static String AB_TITLE = "A/B Test Variation 1";
    final public static String AB_TITLE_2 = "A/B Test Control";
    final public static String AB_DESCRIPTION = "Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through).";


    /*Basic Auth values*/
    final public static String BAT_NOT_AUTH_TEXT = "Not authorized";
    final public static String BAT_TITLE_TEXT = "Basic Auth";
    final public static String BAT_BODY_TEXT = "Congratulations! You must have the proper credentials.";


    /*Challenging DOM values*/
    final public static int CDOM_BUTTONS_LIST_SIZE = 3;
    final public static String CDOM_HEADER_TEXT = "Challenging DOM";
    final public static String CDOM_BODY_TEXT = "The hardest part in automated web testing is finding the best locators (e.g., ones that well named, unique, and unlikely to change). It's more often than not that the application you're testing was not built with this concept in mind. This example demonstrates that with unique IDs, a table with no helpful locators, and a canvas element.";
    public static final List<String> CDOM_TABLE_HEADERS = Arrays.asList("Lorem", "Ipsum", "Dolor", "Sit", "Amet", "Diceret", "Action");
    final public static int CDOM_TABLE_LIST_ROWS_SIZE = 10;
    final public static String CDOM_EDIT_LINK = "https://the-internet.herokuapp.com/challenging_dom#edit";
    final public static String CDOM_DELETE_LINK = "https://the-internet.herokuapp.com/challenging_dom#delete";
    final public static String CDOM_CANVAS_WIDTH = "599";
    final public static String CDOM_CANVAS_HEIGHT = "200";
    final public static String CDOM_CANVAS_STYLE = "border: 1px dotted;";


    /*CheckboxesTest values*/
    final public static String CHBX_HEADER_TEXT = "Checkboxes";
    final public static int CHBX_NUMBER_OF_CHECKBOXES = 2;
    final public static String CHBX_NAME_FIRST_CHECKBOX = "checkbox 1";
    final public static String CHBX_NAME_SECOND_CHECKBOX = "checkbox 2";


    /*ContextMenuTest values*/
    final public static String CM_HEADER = "Context Menu";
    final public static String CM_FIRST_TEXT = "Context menu items are custom additions that appear in the right-click menu.";
    final public static String CM_SECOND_TEXT = "Right-click in the box below to see one called 'the-internet'. When you click it, it will trigger a JavaScript alert.";
    final public static String CM_ALERT_TEXT = "You selected a context menu";


    /*disappearingElementsTest values*/
    final public static String DA_HEADER = "Digest Auth";
    final public static String DA_TEXT = "Congratulations! You must have the proper credentials.";


    /*digestAuthenticationTest values*/
    final public static String DE_HEADER = "Disappearing Elements";
    final public static String DE_TEXT = "This example demonstrates when elements on a page change by disappearing/reappearing on each page load.";
    final public static List<String> DE_BUTTONS_NAME = Arrays.asList("Home", "About", "Contact Us", "Portfolio", "Gallery");


    /*dragAndDropTest values*/
    final public static String DD_HEADER = "Drag and Drop";
    final public static String DD_A = "A";
    final public static String DD_B = "B";


    /*dropdownTest values*/
    final public static String DDT_HEADER = "Dropdown List";
    final public static String DDT_OPTION_1 = "Option 1";
    final public static String DDT_OPTION_2 = "Option 2";


    /*dynamicContentTest values*/
    final public static String DC_HEADER = "Dynamic Content";
    final public static String DC_TEXT = "This example demonstrates the ever-evolving nature of content by loading new text and images on each page refresh.";
    final public static List<String> DC_LIST_OF_TEXT_VALUES = Arrays.asList(testValues.DC_HEADER, testValues.DC_TEXT);


    /*JavaScript Alerts*/
    final public static String ALERT_TEXT_JSALERT = "I am a JS Alert";
    final public static String JSALERT_OK_TEXT_RESULT = "You successfully clicked an alert";
    final public static String ALERT_TEXT_JSALERT_CONFIRM = "I am a JS Confirm";
    final public static String JSALERT_CONFIRM_OK_TEXT_RESULT = "You clicked: Ok";
    final public static String JSALERT_CONFIRM_CANCEL_TEXT_RESULT = "You clicked: Cancel";
    final public static String ALERT_TEXT_JSALERT_PROMPT = "I am a JS prompt";
    final public static String JSALERT_PROMPT_TEXT_RESULT_START = "You entered: ";
    final public static String JSALERT_PROMPT_TEXT_RESULT_ENTER = "Welcome";
    final public static String JSALERT_PROMPT_TEXT_RESULT_NOENTER = null;












}