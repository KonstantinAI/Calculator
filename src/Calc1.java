import java.io.CharConversionException;
import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.util.Scanner;
import static java.lang.String.valueOf;

public class Calc1 {
    public static void main(String[] args) {
        System.out.println("Введите условие");
        Scanner x = new Scanner(System.in);
        String s = x.nextLine();

        try{
            String res = calc(s);
            System.out.println(res);
        }catch (CharacterCodingException ex){
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } catch (CharConversionException exce){
            System.out.println("throws Exeption");
        } catch (IOException except){
            System.out.println("throws Exception//недопустимые числа или операнд");
        } catch (Exception exc){
            System.out.println("Строка не является математической операцией");
        }


    }public static String calc(String s) throws Exception {
            String[] numbers = s.split(" ");
            int a, b;
            char op;
            String c = numbers[0];
            String d = numbers[2];
            String e = numbers[1];
            a = Integer.parseInt(c);
            b = Integer.parseInt(d);
            op = e.charAt(0);

            int l = s.length();
            char space = ' ';
            int spaces = s.length() - s.replace(String.valueOf(space), "").length();

            if (l < 5) {
                throw new Exception();
            }

            if (spaces > 3) {
            throw new CharacterCodingException();
            }

            if (spaces == 3) {
                throw new CharConversionException();
                }

            if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IOException();
            }

                switch (op) {
                    case '+':
                        return valueOf(a + b);
                    case '-':
                        return valueOf(a - b);
                    case '*':
                        return valueOf(a * b);
                    case '/':
                        return valueOf(a / b);
                    default:
                        throw new IOException();

                }

            }
        }