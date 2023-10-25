package lab7;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StreamClass {
    //1 Записать массив целых чисел в двоичный поток. Прочитать массив целых чисел из двоичного потока.
    public static void writeBinary(OutputStream os, int []array) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(os)) {
            for (int item : array) {
                dos.writeInt(item);
            }
        } catch (IOException e) {
            throw e;
        }

    }
    //1
    public static int[] readBinary(InputStream is, int n) throws IOException {
        if (n < 0) {
            throw new IllegalArgumentException("Incorrect position");
        }
        int[] ans = new int[n];
        try(DataInputStream dis = new DataInputStream(is)){
            for(int i = 0; i < ans.length; i++){
                ans[i] = dis.readInt();
            }
        } catch (IOException e) {
            throw e;
        }
        return ans;
    }
    //2 символьный поток разделять числа пробелами
    //каждый элемент массива преобр в стороку с разделителем
    public static void writeTextTxt(Writer writer, int[] array) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(writer)){
            for(int item : array){
                bw.write(item + " ");
            }
        }catch (IOException e){
            throw e;
        }
    }
    //2
    public static int[] readTextTxt(Reader reader, int n) throws IOException {
        if(n < 0){
            throw new IllegalArgumentException("Incorrect position");
        }
        int[] answer = new int[n];
        try(BufferedReader br = new BufferedReader(reader)){
            String str = br.readLine();
            String[] strArr = str.split(" ");
            for(int i = 0; i < n; i++){
                answer[i] = Integer.parseInt(strArr[i]);
            }
            return answer;
        } catch (IOException e) {
            throw e;
        }
    }

    //3 Используя класс RandomAccessFile, прочитайте массив целых чисел, начиная с заданной позиции
    public static int[] readFixPosition(File file, long pos) throws IOException {
        if(pos < 0 || pos > file.length()){
            throw new IllegalArgumentException("Incorrect position");
        }
        int[] answer;
        try(RandomAccessFile raf = new RandomAccessFile(file, "rw")){
            answer = new int[(int)(raf.length() - pos)/Integer.BYTES];
            raf.seek(pos);
            for(int i = 0; i < answer.length; i++){
                answer[i] = raf.readInt();
            }
            return answer;
        } catch (IOException e) {
            throw e;
        }
    }

    //4
//Используя класс File, получить список всех файлов с заданным расширением в заданном каталоге
    public static List<String> getFileExtension(File directory, String extension){
        return new ArrayList<>(Arrays.stream(Objects.requireNonNull(directory.listFiles())).map(File::getName).filter(item->item.endsWith(extension)).collect(Collectors.toList()));
    }
}




