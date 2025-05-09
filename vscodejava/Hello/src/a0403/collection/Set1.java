package a0403.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// 컬렉션
// 1. 데이터를 효율적으로 저장
// 2. 배열보다 유연하게 크기 변경가능
// 3. 자료구조: List, Map, Set
// 4. ArrayList<String> -!제네릭(<타입>지정하는것) 지원으로 타입 안성정 제공
// 5. 다양한 구현체 제공 : 성능과 특징에 맞게 선택가능


//리스트 (순서O, 중복허용 )
// ArrayList 배열기반, 검색빠름, 삽입, 삭제
// LinkedList 연결기반, 검색느림, 삽입삭제 빠름
// Vector ArrayLIst와 유사 스레드 안전
// Stack LIFO(Last-in-First-out) 구조 push()-삽입, pop()-삭제


// Set(순서 X , 중복허용 안함)
// HashSet  해시기반, 요소순서보장 X, 중복불가
// LinkedHashSet  입력순서유지, 중복 불가
// TreeSet 정렬된 상태유지(오름차순)



// Queue(FIFO)


// Map(Key - value, 키 중복)
// HashMap - 키 순서 보장x , 빠른검색속도
// LinkedHashMap - 입력순서 유지
// TreeMap 정렬된 상태  유지(키 기준)



public class Set1 {
    public static void main(String[] args) {
        // 객체선언
        Set<String> set = new HashSet<String>();
        // 데이터 삽입
        set.add("apple");
        set.add("banana");
        set.add("pyopyo");
        set.add("kiwi");
        System.out.println();
        for(String e : set){
            System.out.println(e);
        }
        System.out.println();
        // 데이터 삭제
        set.remove("apple");
        set.add("orange");
        set.add("orange"); //중복된요소 저장불가

        Iterator<String> iterSet = set.iterator();
        while (iterSet.hasNext()) {
            System.out.println(iterSet.next() + " ");
        }
        System.out.println();
        System.out.println(set);

        System.out.println(set.contains("orange"));  //contains - ()안의값이 포함되있나를 true false


        // 전체 데이터 삭제
        set.clear();
        System.out.println(set);
        System.out.println(set.isEmpty());  //set 비어있는지 물어봄 true false
    }
}
