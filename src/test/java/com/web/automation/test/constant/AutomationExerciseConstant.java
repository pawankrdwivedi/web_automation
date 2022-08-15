package com.web.automation.test.constant;

public class AutomationExerciseConstant {

    /**
     * DATA
     */
    public static String DATA_BROKER_EMAIL ="Pawan.Dwivedi@uk.qbe.com";
    public static String DATA_BROKER_NAME="Pawan Dwivedi";
    public static String DATA_INVALID_BROKER_EMAIL ="Pawan.Dwivedi";

    /**
     * RISK STORE API
     */
    public static String API_RISK_STORE_OCS_CASE_DETAILS ="underwritingActivity.externalActivityReference";

    /**
     * Pega QWO API
     */
    public static String API_PEGA_QWO_UNDERWRITER_API_BODY ="{\n" + "\"Message\": \"Security profile changed\",\n"+
            "\"Mode\": \"Operators\",\n"+"\"User\": [\"uwEmail\"]\n"+"}";

    /**
     * PEGA R2
     */
    public static String PEGA_R2_ACTIVE_FRAME_PRE_RENEWAL ="PegaGadget2Ifr";
    public static String PEGA_R2_ACTIVE_FRAME_RENEWAL ="PegaGadget1Ifr";
}
