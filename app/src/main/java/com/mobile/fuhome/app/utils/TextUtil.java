package com.mobile.fuhome.app.utils;

import android.content.Context;
import android.text.InputFilter;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {
    private static String reg = "[^~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……& amp;*（）——+|{}【】‘；：”“’。，、？]";

    /**
     * 只能输入中文、英文、数字、小数点、下划线
     *
     * @param context
     * @param editText
     */
    public static void setEditTextNoSpecialText(final Context context, EditText editText) {
        InputFilter[] filter = new InputFilter[1];
        editText.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        filter[0] = new EditTextFilter("[\\u4E00-\\u9FA5.\\w ]+");
        editText.setFilters(filter);
    }

    public static void setEditTextNoSpecialText(final Context context, EditText editText, String regEx) {
        InputFilter[] filter = new InputFilter[1];
        editText.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        filter[0] = new EditTextFilter(regEx);
        editText.setFilters(filter);
    }

    /**
     * 只能输入字母和数字
     *
     * @param context
     * @param editText
     */
    public static void setEditTextNumberAndLetterText(final Context context, EditText editText) {
        InputFilter[] filter = new InputFilter[1];
        editText.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        filter[0] = new EditTextFilter("[A-Za-z0-9]+");
        editText.setFilters(filter);
    }

    public static String byte2HexStr(byte[] b) {
        String stmp = "";
        StringBuilder sb = new StringBuilder("");
        for (int n = 0; n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0xFF);
            sb.append((stmp.length() == 1) ? "0" + stmp : stmp);
            sb.append(" ");
        }
        return sb.toString().toUpperCase().trim();
    }

    public static boolean isMobileNO(String mobiles) {

        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

        Matcher m = p.matcher(mobiles);

        return m.matches();
    }

}
