//Вариант 1
// Разработайте многопоточное приложение для побайтового копирования файла.
// Продемонстрируйте работу одноовременного копирования файла в несколько файлов.

import java.util.Observable;

public class Main extends Thread{

    private int n;

    public Main(int n){
        this.n = n;
    }

    public void run(){
        Action1<int> action = (int n) -> {
            @Override
            public void call(int n){
                String text = makeText();
                String newText = "";
                for (int i = 0; i < text.length(); i++){
                    char ch = text.charAt(i);
                    newText += ch;
                    System.out.println("поток " + n);
                }
                System.out.println(newText);
            }
        };
    }

    public static void main(String[] args){
        Observable<int> observable = Observable.just(1, 2, 3);
        observable.subscribe(action);
    }

    public String makeText(){
        String text = "Австрия потеряла Венецию и признала объединение северогерманских государств с Пруссией. Вскоре после этого венгерская элита при посредничестве супруги Франца Елизаветы Баварской добилась от Франца Иосифа предоставления ей равных прав с австрийскими немцами и преобразования Австрийской империи в двуединую монархию. Опасаясь новой революции, император, в 1853 году чуть не убитый венгерским националистом, был вынужден согласиться. Это привело к началу национального движения и среди других народов дунайской монархии.";
        return text;
    }
}
