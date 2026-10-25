package mappiesimerkkejä;

import java.util.HashMap;
import java.util.Set;

public class MapNimet {
    public static void main(String[] args) {
        
        // MAPIN LUONTI
        HashMap<String, Integer> nimetJaArvosanat = new HashMap<>();
        // ARVOJEN LAITTO MAPPIIN
        nimetJaArvosanat.put("Arno", 5);
        nimetJaArvosanat.put("Arton", 5);
        nimetJaArvosanat.put("Tea", 5);

        // TULOSTETAAN ARNON ARVOSANA
        System.out.println(nimetJaArvosanat.get("Arno"));

        // KAIKKIEN ARVOJEN LÄPIKÄYNTI
        // TARVITAAN KEINO HAKEA LISTA AVAIMIA
        Set<String> arvot = nimetJaArvosanat.keySet();

        for (String nimi : arvot) {
            System.out.println(nimi);
        }


    }

}
