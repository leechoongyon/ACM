package test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
        A a = new A(10000);
        A a1 = new A(20000);
        A a2 = new A(30000);
        A a3 = new A(40000);
        A a4 = new A(50000);

        List<A> aList = new ArrayList<>();
        aList.add(a);
        aList.add(a1);
        aList.add(a2);
        B b = new B();
        b.setList(aList);

        List<A> aList1 = new ArrayList<>();
        aList1.add(a);
        aList1.add(a1);
        aList1.add(a2);
        aList1.add(a3);
        aList1.add(a4);
        B b1 = new B();
        b1.setList(aList1);

        List<B> list = new ArrayList<>();
        list.add(b);
        list.add(b1);


        /** 특정 숫자를 초과하는 대상을 추출해라. */
        List<A> tmp = list.stream().map(s -> s.getList())
                .flatMap(List::stream)
                .filter(bb -> bb.getNum() > 10000)
                .collect(Collectors.toList());
        tmp.forEach(i -> System.out.println("num : " + i.getNum()));
    }


    public static class B {
        private List<A> list;

        public void setList(List<A> list) {
            this.list = list;
        }

        public List<A> getList() {
            return list;
        }
    }

    public static class A {
        private int num;

        public A(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }
}
