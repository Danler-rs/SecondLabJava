package SecondLab;

public class Task2 {
    public static void main(String[] args) {
        int i = 4;

        int i_1 = 22;
        int i_2 = 36;

        System.out.println("--- В десят виде ---");
        System.out.println(i);
        System.out.println(i<<1);

        System.out.println("\n --- В двоич виде ---");
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i<<1));

        System.out.println("\n --- В двоич виде через методы влево---");
        int new_i_L = sdvigVlevo(i, 1);
        System.out.println(new_i_L);
        System.out.println(Integer.toBinaryString(new_i_L));

        System.out.println("\n --- В двоич виде через методы вправо---");
        int new_i_R = sdvigVlevo(i, 1);
        System.out.println(new_i_R);
        System.out.println(Integer.toBinaryString(new_i_R));

        System.out.println("\n --- И ---");
        int resAND = bitAND(i_1, i_2);
        System.out.println(Integer.toBinaryString(resAND));

        System.out.println("\n --- ИЛИ ---");
        int resOR = bitOR(i_1, i_2);
        System.out.println(Integer.toBinaryString(resOR));

        System.out.println("\n --- Исключающее или ---");
        int resXOR = bitXOR(i_1, i_2);
        System.out.println(Integer.toBinaryString(resXOR));

        System.out.println("\n --- НЕ ---");
        int resNOT = bitNOT(i_1);
        System.out.println(Integer.toBinaryString(resNOT));


        BitArray bitArray = new BitArray(10);
        bitArray.set(0, 1);
        bitArray.set(9, 1);

        bitArray.set(5, 1);
        bitArray.set(5, 0);

        System.out.println(bitArray.toString());
    }

    public static String binaryStr(int b){
        return "0b" + Integer.toBinaryString(0b100000000 | (b & 0xff)).substring(1);
    }

    public static void printBinary(int b){
        System.out.println("0b" + Integer.toBinaryString(0b10000000 | (b & 0xff)).substring(1));
    }
    public static class BitArray{
        int size;
        byte[] bytes;
        private byte[] masks = new byte[] {0b00000001, 0b00000010, 0b00000100, 0b00001000, 0b00010000, 0b00100000, 0b01000000, (byte) 0b10000000};

        public BitArray(int size){
            this.size = size;
            int SizeInBytes = size/8;
            if(size % 8 > 0){
                SizeInBytes = SizeInBytes + 1;
            }
            bytes = new byte[SizeInBytes];
        }

        public int get(int index){
            int byteIndex = index / 8;
            int bitIndex = index % 8;
            return (bytes[byteIndex] & masks[bitIndex]) > 0 ? 1 : 0;
        }


        public void set(int index, int value){
            int byteIndex = index / 8;
            int bitIndex = index % 8;
            if (value > 0){
                bytes[byteIndex] = (byte) (bytes[byteIndex] | masks[bitIndex]);
            } else {
                bytes[byteIndex] = (byte) (bytes[byteIndex] & ~masks[bitIndex]);
            }
        }
        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i ++){
                sb.append(get(i) > 0 ? '1': '0');

            }
            return sb.toString();
        }
    }
    public static int sdvigVlevo (int i, int sdvigNa){
        int new_i = 0;
        for (int k = 0; k <= sdvigNa; k++){
            new_i = i<<k;
        }
        return new_i;
    }

    public static int sdvigVPravo (int i, int sdvigNa){
        int new_i = 0;
        for (int k = 0; k <= sdvigNa; k++){
            new_i = i>>k;
        }
        return new_i;
    }

    public static int bitOR(int i, int k){
        int result = i | k;
        return result;
    }

    public static int bitAND(int i, int k){
        int result = i & k;
        return result;
    }

    public static int bitXOR(int i, int k){
        int result = i ^ k;
        return result;
    }

    public static int bitNOT(int i){
        int result = ~i;
        return result;
    }


}