import java.util.Arrays;

public class Main {

    public int sumLastNums(int x) {
        int n = Math.abs(x);
        return n % 10 + (n / 10) % 10;
    }

    public int charToNum(char x) {
        return x - '0';
    }

    public boolean isUpperCase(char x) {
        return x >= 'A' && x <= 'Z';
    }

    public boolean isDivisor(int a, int b) {
        if (a == 0 && b == 0) return false;
        if (a != 0 && b % a == 0) return true;
        if (b != 0 && a % b == 0) return true;
        return false;
    }

    public int lastNumSum(int a, int b) {
        return Math.abs(a % 10) + Math.abs(b % 10);
    }

    public int abs(int x) {
        if (x < 0) return -x;
        return x;
    }

    public double safeDiv(int x, int y) {
        if (y == 0) return 0;
        return (double) x / y;
    }

    public int sum2(int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 19) return 20;
        return sum;
    }

    public String age(int x) {
        int lastTwo = Math.abs(x) % 100;
        int last = Math.abs(x) % 10;
        String word;

        if (lastTwo >= 11 && lastTwo <= 14) {
            word = "лет";
        } else if (last == 1) {
            word = "год";
        } else if (last >= 2 && last <= 4) {
            word = "года";
        } else {
            word = "лет";
        }

        return x + " " + word;
    }

    public String day(int x) {
        switch (x) {
            case 1: return "понедельник";
            case 2: return "вторник";
            case 3: return "среда";
            case 4: return "четверг";
            case 5: return "пятница";
            case 6: return "суббота";
            case 7: return "воскресенье";
            default: return "это не день недели";
        }
    }

    public String chet(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= x; i += 2) {
            sb.append(i).append(' ');
        }
        return sb.toString().trim();
    }

    public int numLen(long x) {
        if (x == 0) return 1;
        long n = Math.abs(x);
        int count = 0;
        while (n > 0) {
            count++;
            n /= 10;
        }
        return count;
    }

    public void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public void leftTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < x - i; j++) {
                System.out.print(' ');
            }
            for (int j = 0; j < i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public int[] add(int[] arr, int x, int pos) {
        if (pos < 0 || pos > arr.length) {
            throw new IllegalArgumentException("Некорректная позиция");
        }

        int[] result = new int[arr.length + 1];

        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }

        result[pos] = x;

        for (int i = pos; i < arr.length; i++) {
            result[i + 1] = arr[i];
        }

        return result;
    }

    public int[] add(int[] arr, int[] ins, int pos) {
        if (pos < 0 || pos > arr.length) {
            throw new IllegalArgumentException("Некорректная позиция");
        }

        int[] result = new int[arr.length + ins.length];

        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }

        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }

        for (int i = pos; i < arr.length; i++) {
            result[i + ins.length] = arr[i];
        }

        return result;
    }

    public void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    public int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int value : arr) {
            if (value == x) count++;
        }

        int[] result = new int[count];
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[index++] = i;
            }
        }

        return result;
    }

    public int[] deleteNegative(int[] arr) {
        int count = 0;
        for (int value : arr) {
            if (value >= 0) count++;
        }

        int[] result = new int[count];
        int index = 0;

        for (int value : arr) {
            if (value >= 0) {
                result[index++] = value;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Main lab = new Main();

        System.out.println("Задание №1");
        System.out.println("2. " + lab.sumLastNums(4568));
        System.out.println("3. " + lab.charToNum('3'));
        System.out.println("6. " + lab.isUpperCase('D'));
        System.out.println("8. " + lab.isDivisor(3, 6));
        System.out.println("10. " + lab.lastNumSum(5, 11));

        System.out.println();
        System.out.println("Задание №2");
        System.out.println("1. " + lab.abs(-3));
        System.out.println("2. " + lab.safeDiv(5, 0));
        System.out.println("7. " + lab.sum2(5, 7));
        System.out.println("8. " + lab.age(31));
        System.out.println("9. " + lab.day(5));

        System.out.println();
        System.out.println("Задание №3");
        System.out.println("3. " + lab.chet(9));
        System.out.println("5. " + lab.numLen(12567));
        System.out.println("7.");
        lab.square(4);
        System.out.println("8.");
        lab.leftTriangle(4);
        System.out.println("9.");
        lab.rightTriangle(4);

        System.out.println();
        System.out.println("Задание №4");
        System.out.println("4. " + Arrays.toString(lab.add(new int[]{1, 2, 3, 4, 5}, 9, 3)));
        System.out.println("5. " + Arrays.toString(lab.add(new int[]{1, 2, 3, 4, 5}, new int[]{7, 8, 9}, 3)));

        int[] arr6 = {1, 2, 3, 4, 5};
        lab.reverse(arr6);
        System.out.println("6. " + Arrays.toString(arr6));

        System.out.println("9. " + Arrays.toString(lab.findAll(new int[]{1, 2, 3, 8, 2, 2, 9}, 2)));
        System.out.println("10. " + Arrays.toString(lab.deleteNegative(new int[]{1, 2, -3, 4, -2, 2, -5})));
    }
}