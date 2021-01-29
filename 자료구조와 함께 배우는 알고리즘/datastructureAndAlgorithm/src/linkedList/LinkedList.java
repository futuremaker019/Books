package linkedList;

public class LinkedList<E> {

    private Node<E> head;       // 머리 노드
    private Node<E> current;    // 선택 노드

    // 노드
    class Node<E> {
        private E data;         // 데이터
        private Node<E> next;   // 뒤쪽 포인터 (다음 노드 참조)

        // 생성자
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}
