/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialj;

/**
 *
 * @author Xiaoxing
 */
public class EventNames {

    final static private String[] EvtAnno = new String[91];
//    final static private String[] permMessage = new String[255];

    static public String[] init() {

        EvtAnno[0] = "Lick";

        EvtAnno[1] = "Keypad";

        EvtAnno[2] = "DebugInfo";

        EvtAnno[3] = "IO";

        EvtAnno[4] = "FalseAlarm";

        EvtAnno[5] = "CorrectRejection";

        EvtAnno[6] = "Miss";

        EvtAnno[7] = "Hit";

        EvtAnno[8] = "Water_sweet";

        EvtAnno[9] = "Odor_A";

        EvtAnno[10] = "Odor_B";

        EvtAnno[11] = "Distractor Sample";

        EvtAnno[12] = "Distractor Test";

        EvtAnno[13] = "Valve6";

        EvtAnno[14] = "Valve7";

        EvtAnno[15] = "Valve8";

        EvtAnno[16] = "Out1";

        EvtAnno[17] = "Out2";

        EvtAnno[18] = "Out3";

        EvtAnno[19] = "Out4";

        EvtAnno[20] = "Trial_Wait";

        EvtAnno[21] = "S1S2";

        EvtAnno[22] = "S1S3";

        EvtAnno[23] = "High Value";

        EvtAnno[24] = "Low Value";

        EvtAnno[25] = "S2S1";

        EvtAnno[26] = "S2S2";

        EvtAnno[27] = "S2S3";

        EvtAnno[28] = "S2S4";

        EvtAnno[29] = "S2S5";

        EvtAnno[30] = "S3S1";

        EvtAnno[31] = "S3S2";

        EvtAnno[32] = "S3S3";

        EvtAnno[33] = "S3S4";

        EvtAnno[34] = "S3S5";

        EvtAnno[35] = "S4S1";

        EvtAnno[36] = "S4S2";

        EvtAnno[37] = "S4S3";

        EvtAnno[38] = "S4S4";

        EvtAnno[39] = "S4S5";

        EvtAnno[40] = "S5S1";

        EvtAnno[41] = "S5S2";

        EvtAnno[42] = "S5S3";

        EvtAnno[43] = "S5S4";

        EvtAnno[44] = "S5S5";

        EvtAnno[51] = "StepN";

        EvtAnno[52] = "SessN";

        EvtAnno[49] = "trialNperSess";

        EvtAnno[45] = "SessHit";

        EvtAnno[46] = "SessMiss";

        EvtAnno[47] = "SessFA";

        EvtAnno[48] = "SessCR";

        EvtAnno[50] = "SessCorrRate";

        EvtAnno[53] = "FirOdor";

        EvtAnno[54] = "FirOdorL";

        EvtAnno[55] = "OdorDelay";

        EvtAnno[56] = "SecOdor";

        EvtAnno[57] = "SecOdorL";

        EvtAnno[58] = "trialtype";

        EvtAnno[59] = "ITI";

        EvtAnno[60] = "proLpun";

        EvtAnno[61] = "Sess";

        EvtAnno[62] = "Train";

        EvtAnno[65] = "laser";

        EvtAnno[66] = "Odor_C";

        EvtAnno[64] = "Odor_D";

        EvtAnno[67] = "Hit2";

        EvtAnno[68] = "Miss2";

        EvtAnno[69] = "FalseAlarm2";

        EvtAnno[70] = "FID";

        EvtAnno[71] = "LickDisp";

        EvtAnno[72] = "Miss3";

        EvtAnno[73] = "FalseAlarm3";

        EvtAnno[74] = "CorrectRejection3";

        EvtAnno[75] = "Hit4";

        EvtAnno[76] = "Miss4";

        EvtAnno[77] = "FalseAlarm4";

        EvtAnno[78] = "CorrectRejection4";

        EvtAnno[79] = "LaserSwitch";

        EvtAnno[82] = "BallMove";

        EvtAnno[83] = "OdorE";

        EvtAnno[84] = "AbortTrial";

        EvtAnno[85] = "CorrectionCue";
        EvtAnno[89] = "Choice";
        EvtAnno[90] = "Confidence";

//
//        //List of Permanent Messages
//        permMessage[0] = "loop1step2";
//        permMessage[1] = "loop1step3";
//        permMessage[2] = "loop2step2";
//        permMessage[3] = "loop2step3";
//        permMessage[4] = "loop3step2";
//        permMessage[5] = "loop3step3";
//        permMessage[100] = "DMS LR Teach L--";
//        permMessage[101] = "DMS LR Teach L++";
//        permMessage[102] = "MSWOD LR Teach L--";
//        permMessage[103] = "DMS LR Teach L+-";
//        permMessage[104] = "DMS LR 5Delay L+-";
//        permMessage[105] = "DMS LR 8Delay L+-";
//        permMessage[106] = "DMS LR 12Delay L+-";
//        permMessage[107] = "DMS LR 1stOdor L+-";
//        permMessage[108] = "DMS LR 2ndOdor L+-";
//        permMessage[109] = "DMS LR bothOdor L+-";
//        permMessage[110] = "DMS LR baseline L+-";
//        permMessage[111] = "DMS LR response L+-";
        return EvtAnno;

    }

//    final public static String getMessage(int i) {
//        if (i >= 0 && i <= 255) {
//            return permMessage[i];
//        }
//        return "";
//    }
}
