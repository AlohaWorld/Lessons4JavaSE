package unit02;

public class Reverse {

  public static int[] reverse(int[] list) {

    int[] result = new int[list.length];

    for (int i = 0, j = result.length - 1; i < list.length; i++, j--) {
      result[j] = list[i];
    }

    return result;
  }

  @SuppressWarnings("unused")
  public static void main(String[] args) {
    int[] list1 = new int[] {1, 2, 3, 4, 5, 6};
    int[] list2 = reverse(list1);
  }
}
