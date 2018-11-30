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

    final static private String[] trans = new String[91];
//    final static private String[] permMessage = new String[255];

    static public String[] init() {

        trans[0] = "Lick";

        trans[1] = "Keypad";

        trans[2] = "DebugInfo";

        trans[3] = "IO";

        trans[4] = "FalseAlarm";

        trans[5] = "CorrectRejection";

        trans[6] = "Miss";

        trans[7] = "Hit";

        trans[8] = "Water_sweet";

        trans[9] = "Odor_A";

        trans[10] = "Odor_B";

        trans[11] = "Distractor Sample";

        trans[12] = "Distractor Test";

        trans[13] = "Valve6";

        trans[14] = "Valve7";

        trans[15] = "Valve8";

        trans[16] = "Out1";

        trans[17] = "Out2";

        trans[18] = "Out3";

        trans[19] = "Out4";

        trans[20] = "Trial_Wait";

        trans[21] = "S1S2";

        trans[22] = "S1S3";

        trans[23] = "High Value";

        trans[24] = "Low Value";

        trans[25] = "S2S1";

        trans[26] = "S2S2";

        trans[27] = "S2S3";

        trans[28] = "S2S4";

        trans[29] = "S2S5";

        trans[30] = "S3S1";

        trans[31] = "S3S2";

        trans[32] = "S3S3";

        trans[33] = "S3S4";

        trans[34] = "S3S5";

        trans[35] = "S4S1";

        trans[36] = "S4S2";

        trans[37] = "S4S3";

        trans[38] = "S4S4";

        trans[39] = "S4S5";

        trans[40] = "S5S1";

        trans[41] = "S5S2";

        trans[42] = "S5S3";

        trans[43] = "S5S4";

        trans[44] = "S5S5";

        trans[51] = "StepN";

        trans[52] = "SessN";

        trans[49] = "trialNperSess";

        trans[45] = "SessHit";

        trans[46] = "SessMiss";

        trans[47] = "SessFA";

        trans[48] = "SessCR";

        trans[50] = "SessCorrRate";

        trans[53] = "FirOdor";

        trans[54] = "FirOdorL";

        trans[55] = "OdorDelay";

        trans[56] = "SecOdor";

        trans[57] = "SecOdorL";

        trans[58] = "trialtype";

        trans[59] = "ITI";

        trans[60] = "proLpun";

        trans[61] = "Sess";

        trans[62] = "Train";

        trans[65] = "laser";

        trans[66] = "Odor_C";

        trans[64] = "Odor_D";

        trans[67] = "Hit2";

        trans[68] = "Miss2";

        trans[69] = "FalseAlarm2";

        trans[70] = "FID";

        trans[71] = "Hit3";

        trans[72] = "Miss3";

        trans[73] = "FalseAlarm3";

        trans[74] = "CorrectRejection3";

        trans[75] = "Hit4";

        trans[76] = "Miss4";

        trans[77] = "FalseAlarm4";

        trans[78] = "CorrectRejection4";

        trans[79] = "LaserSwitch";

        trans[82] = "BallMove";

        trans[83] = "OdorE";

        trans[84] = "AbortTrial";

        trans[85] = "CorrectionCue";
        trans[89] = "Choice";
        trans[90] = "Confidence";

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
        return trans;

    }

//    final public static String getMessage(int i) {
//        if (i >= 0 && i <= 255) {
//            return permMessage[i];
//        }
//        return "";
//    }
}
