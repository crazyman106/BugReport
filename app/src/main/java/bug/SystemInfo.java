package bug;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.TelephonyManager;

import java.util.List;

/**
 * Created by Administrator on 2018/3/18.
 */

public class SystemInfo {

    private static Context mContext;
    static TelephonyManager telephonyManager;

    public static void init(Context context) {
        mContext = context;
        telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }

    //手机串号:GSM手机的IMEI 和 CDMA手机的 MEID.
    public static String getDeviceID() {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return telephonyManager.getDeviceId();
        }
        return null;
    }

    //手机号(有些手机号无法获取，是因为运营商在SIM中没有写入手机号)
    public static String getTel() {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return telephonyManager.getLine1Number();
        }
        return null;
    }

    //获取手机SIM卡的序列号
    public static String getSimSerialNumber() {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return telephonyManager.getSimSerialNumber();
        }
        return null;
    }

    //获取客户id，在gsm中是imsi号
    public static String getSubscriberId() {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return telephonyManager.getSubscriberId();
        }
        return null;
    }

    //电话方位
    public static CellLocation getCellLocationt() {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return telephonyManager.getCellLocation();
        }
        return null;
    }

    //运营商名称,注意：仅当用户已在网络注册时有效,在CDMA网络中结果也许不可靠
    public static String getNetworkoperatorName() {
        return telephonyManager.getNetworkOperatorName();
    }

    //取得和语音邮件相关的标签，即为识别符
    public static String getVoiceMail() {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return telephonyManager.getVoiceMailAlphaTag();
        }
        return null;
    }

    //获取语音邮件号码：
    public static String getVoiceMailNumber() {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return telephonyManager.getVoiceMailNumber();
        }
        return null;
    }

    //获取ISO国家码，相当于提供SIM卡的国家码。
    public static String getSimCountryIso() {
        return telephonyManager.getSimCountryIso();
    }

    public static int getCallState() {
        return telephonyManager.getCallState();
    }

    public static String getDevicesoftware() {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return telephonyManager.getDeviceSoftwareVersion();
        }
        return null;
    }

    public static String getNetworkCountry() {
        return telephonyManager.getNetworkCountryIso();
    }

    public static String getNetworkoperator() {
        return telephonyManager.getNetworkOperator();
    }

    public static int getPhoneType() {
        return telephonyManager.getPhoneType();
    }

    public static String getSimOperator() {
        return telephonyManager.getSimOperator();
    }

    public static String getSimOperatorName() {
        return telephonyManager.getSimOperatorName();
    }

    public static int getSimStat() {
        return telephonyManager.getSimState();
    }

    public static boolean isHasIcc() {
        return telephonyManager.hasIccCard();
    }

    public static boolean isRoaming() {
        return telephonyManager.isNetworkRoaming();
    }

    public static List<NeighboringCellInfo> getNeighboringCellInfo() {
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return telephonyManager.getNeighboringCellInfo();
        }
        return null;
    }

    public static int getNetWorkType() {
        return telephonyManager.getDataActivity();
    }
}
