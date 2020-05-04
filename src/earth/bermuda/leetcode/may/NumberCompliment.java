package earth.bermuda.leetcode.may;

import java.util.Arrays;

public class NumberCompliment {
    public int findComplement(int num) {
        int [] powersOf2 = new int[] {
                0x00000000,
                0x00000001,
                0x00000002,
                0x00000004,
                0x00000008,
                0x00000010,
                0x00000020,
                0x00000040,
                0x00000080,
                0x00000100,
                0x00000200,
                0x00000400,
                0x00000800,
                0x00001000,
                0x00002000,
                0x00004000,
                0x00008000,
                0x00010000,
                0x00020000,
                0x00040000,
                0x00080000,
                0x00100000,
                0x00200000,
                0x00400000,
                0x00800000,
                0x01000000,
                0x02000000,
                0x04000000,
                0x08000000,
                0x10000000,
                0x20000000,
                0x40000000
        };
        int [] powersOf2minus1 = new int[] {
                0x00000000,
                0x00000001,
                0x00000003,
                0x00000007,
                0x0000000f,
                0x0000001f,
                0x0000003f,
                0x0000007f,
                0x000000ff,
                0x000001ff,
                0x000003ff,
                0x000007ff,
                0x00000fff,
                0x00001fff,
                0x00003fff,
                0x00007fff,
                0x0000ffff,
                0x0001ffff,
                0x0003ffff,
                0x0007ffff,
                0x000fffff,
                0x001fffff,
                0x003fffff,
                0x007fffff,
                0x00ffffff,
                0x01ffffff,
                0x03ffffff,
                0x07ffffff,
                0x0fffffff,
                0x1fffffff,
                0x3fffffff,
                0x7fffffff
        };
        int index = Arrays.binarySearch(powersOf2, num);
        if (index < 0) {
            index = ~index - 1;
        }
        return num ^ powersOf2minus1[index];
    }
}
