package question;

import model.ListNode;

/**
 * 2
 * Created by RuiL on 2017/7/20.
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = (l1.val + l2.val) / 10;

        ListNode result = new ListNode((l1.val + l2.val) % 10);
        l1 = l1.next;
        l2 = l2.next;
        ListNode firstNode = result;

        boolean flag = true;
        while (flag){

            flag = false;

            if (l1 != null && l2 != null){
                ListNode thisNode = new ListNode((l1.val + l2.val + carry) % 10);

                carry = (l1.val + l2.val + carry) / 10;

                result.next = thisNode;
                result = result.next;
                l1 = l1.next;
                l2 = l2.next;

                flag = true;
                continue;
            }

            if(l1 == null && l2 != null){
                ListNode thisNode = new ListNode((l2.val + carry) % 10);

                carry = (l2.val + carry) / 10;

                result.next = thisNode;
                result = result.next;

                l2 = l2.next;

                flag = true;
                continue;
            }

            if(l1 != null){
                ListNode thisNode = new ListNode((l1.val + carry) % 10);

                carry = (l1.val + carry) / 10;

                result.next = thisNode;
                result = result.next;

                l1 = l1.next;
                flag = true;

                continue;
            }


            if(carry != 0){
                ListNode thisNode = new ListNode(carry);

                carry = 0;

                result.next = thisNode;
                result = result.next;
            }
        }

        return firstNode;

    }

}

