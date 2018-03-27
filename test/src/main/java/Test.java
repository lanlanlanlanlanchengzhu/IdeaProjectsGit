import java.util.*;

public class Test {

    public static void main(String[] args) {
        String s1 = "rpid,merId,orderId,merDate,amount,amtType,version,service,goodsId,goodsInf,mobileId,bankType,gateId,retUrl,notifyUrl,merPriv,expand,needVerifySign,merCustId,custIp,payType,splitType,mediaType,mediaId,expireTime,splitData,splitCategory,bProductId,ubAgreementId,pAgreementId,userIp,comAmtType";
        String s2 = "rpid,reqDate,reqTime,merId,notifyUrl,orderId,orderDate,origAmt,inAccountPro,inMediaId,inAccountName,inBankAccType,binBankId,bankBrhName,purpose,mobileNo,cutFeeType,comAmtType,setComType,productId,provName,cityName,cnapsCode";
        String s3 = "rpid,reqDate,reqTime,orderId,orderDate,merId,amount,accType,feeMode";

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        s3 = s3.toLowerCase();

        String[] s1Array = s1.split(",");
        String[] s2Array = s2.split(",");
        String[] s3Array = s3.split(",");

        String[] allArray = new String[s1Array.length + s2Array.length + s3Array.length];

        System.arraycopy(s1Array, 0, allArray, 0, s1Array.length);
        System.arraycopy(s1Array, 0, allArray, s1Array.length, s2Array.length);
        System.arraycopy(s1Array, 0, allArray, s1Array.length + s2Array.length, s3Array.length);

        List<String> s1List = new ArrayList<String>(Arrays.asList(s1Array));
        List<String> s2List = new ArrayList<String>(Arrays.asList(s2Array));
        List<String> s3List = new ArrayList<String>(Arrays.asList(s3Array));
        List<String> allList = new ArrayList<String>(Arrays.asList(allArray));

        Set<String> resultSet = new HashSet<String>();
        String temp = "";
        for (int i = 0; i < allList.size(); i++) {
            temp = allList.get(i);
            if(s1List.contains(temp) && s2List.contains(temp) && s3List.contains(temp)){
                resultSet.add(temp);
            }
        }

        System.out.println(resultSet);

    }

}
