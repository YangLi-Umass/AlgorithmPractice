package MyString;

/**
 * Created by li on 1/7/2017.
 */
public class AddBinary67Jan7 {
    /**
     * My solution
     *
     * */
    public String addBinary(String a, String b) {
        int i = 0;
        int aLen = a.length(), bLen = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0,temp = 0;
        int n1,n2;
        while(aLen-i > 0 || bLen-i > 0) {
            if(aLen-i > 0) n1 = a.charAt(aLen-i-1) == '1' ? 1:0;
            else n1 = 0;

            if(bLen-i > 0) n2 = b.charAt(bLen-i-1) == '1' ? 1:0;
            else n2 = 0;

            temp = (n1+n2+carry) % 2 == 1 ? 1:0;
            carry = (n1+n2+carry > 1) ? 1:0;

            sb.append(temp);
            i++;
        }

        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
    }

    /**
     * More tricky
     *
     * */
    public String addBinary1(String a, String b) {
        int i = 0;
        int aLen = a.length(), bLen = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0, sum = 0;
        while(aLen-i > 0 || bLen-i > 0) {
            sum = carry;
            if(aLen-i > 0) sum += a.charAt(aLen-i-1) - '0';
            if(bLen-i > 0) sum += b.charAt(bLen-i-1) - '0';

            sb.append(sum%2);
            carry = sum/2;
            i++;
        }

        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
