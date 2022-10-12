import java.util.*;

public class Deck {

    public static void main(String[] args)
    {
        //Se inician las variables
        int PALOS = Cartas.simbol.length;
        int VALORES = Cartas.num.length;
        int opciones = 0;
        int ban = 0;

        Scanner leer = new Scanner(System.in);

        //  Se genera el ciclo para la selección de cartas que se tienen
        ArrayList<String> Deck = new ArrayList<String>();

        for (int i = 0; i < VALORES ; i++)
        {
            for (int j = 0; j < PALOS; j++)
            {
                if (Cartas.simbol[j].equals("Corazon") || Cartas.simbol[j].equals("Diamante"))
                    Deck.add(Cartas.simbol[j] +" / "+ Cartas.color[0] +" / "+ Cartas.num[i]);
                else
                    Deck.add(Cartas.simbol[j] +" / "+ Cartas.color[1] +" / "+ Cartas.num[i]);
            }
        }


        /* Este ciclo reccorre los el mazo y lo despliega */
        Iterator<String> nombreIterator = Deck.iterator();
        while(nombreIterator.hasNext()){
            String elemento = nombreIterator.next();
            System.out.print(elemento+" | ");
        }

        //Se despliega el menú
        System.out.println("Bienvenid@ :) ");

        do
        {
            try{

                System.out.println(" \n ----Poker-sillo.com----");
                System.out.println(" \n ----- Menú -----");
                System.out.println("\n Selecciona una opción");
                System.out.println("1 - Mezcla");
                System.out.println("2 - Tomar una carta");
                System.out.println("3 - Tomar carta al azar");
                System.out.println("4 - Tomar 5 cartas");
                System.out.println("0 - SALIR");
                System.out.println(" \n --------------");
                opciones = leer.nextInt();

                // Dependiendo de la opción se realizara lo que el ususario haya pedido
                switch(opciones)
                {
                    case 1:
                        shuffle(Deck);
                        break;

                    case 2:
                        head(Deck);
                        break;

                    case 3:
                        pick(Deck);
                        break;

                    case 4:
                        if(Deck.size()>= 5)
                            hand(Deck);

                        else
                            System.out.println("\n Se acabaron las cartas, elije otra opción");
                        break;

                    case 0:
                        System.out.println("\n Las Cartas:  ");
                        ban = 1;
                        break;

                    default:
                        System.out.println("\n ERROR");
                        System.out.println("¡¡Seleccione una opción dentro del rango!! ");
                        break;

                }

                //aquí se muestra el final cuando ya no tengamos cartas
                if(Deck.size() == 0){
                    System.out.println("\n Ya no hay más");
                    System.out.println("FIN DEL JUEGO");
                    break;
                }
            }

            //Aquí se encuentra la línea de exeption
            catch (Exception e)
            {
                System.out.println("\n ERROR ERROR ERROR ERROR ERROR ERROR");
                break;

            }
        }while(ban == 0);


    }

    //metodos a realizar para cada una de las opciones

    //Se mezclan las cartas
    public static void shuffle(ArrayList deck){
        ArrayList<String> values = deck;
        Collections.shuffle(values);
        System.out.println("\n Se mezcló el Deck correctramente");
        Iterator<String> nombreIterator2 = deck.iterator();
        while(nombreIterator2.hasNext()){
            String elemento = nombreIterator2.next();
            System.out.print(elemento+" | ");
        }
    }

    //  Muestra las cartas restantes
    public static void head(ArrayList deck){
        System.out.println(deck.get(0));
        deck.remove(0);
        System.out.println("\n Quedan " + deck.size() + " cartas \n");
    }

    //Mustra las cartas sobrantes aleatorias
    public static void pick(ArrayList  deck){
        Random aleatorio = new Random();
        System.out.println(deck.get(aleatorio.nextInt(deck.size())));
        deck.remove(aleatorio.nextInt(deck.size()));
        System.out.println("\n Quedan " + deck.size() + " cartas \n");
    }

    public static void hand(ArrayList deck){
        for(int i=0; i<=4; i++){
            System.out.println(deck.get(i));
        }
        for(int i=0; i<=4; i++){
            deck.remove(i);
        }
        System.out.println("\n Quedan " + deck.size()+ " cartas");
    }

}