import java.io.*;
import java.util.*;

class Terret {
    int x;
    int y;
    int r;

    Terret(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            Terret[] terrets = new Terret[2];
            for (int i = 0; i < 2; i++) {
                terrets[i] = new Terret(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
            System.out.println(solve(terrets));

        }

    }

    public static int solve(Terret[] terrets) {
        Terret zo = terrets[0];
        Terret back = terrets[1];

        int dx = zo.x - back.x;
        int dy = zo.y - back.y;

        long dist2 = dx * dx + dy * dy;
        int rSum = zo.r + back.r;
        int rDiff = Math.abs(zo.r - back.r);

        if (dist2 == 0 && zo.r == back.r)
            return -1;
        else if (dist2 > rSum * rSum)
            return 0;
        else if (dist2 == rSum * rSum)
            return 1;
        else if (dist2 < rSum * rSum && dist2 > rDiff * rDiff)
            return 2;
        else if (dist2 == rDiff * rDiff)
            return 1;

        return 0;

    }

}