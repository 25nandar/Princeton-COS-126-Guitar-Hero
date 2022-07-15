public class GuitarHero {
    public static void main(String[] args) {
        String keyboardString = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString obj[] = new GuitarString[keyboardString.length()];

        // create two guitar strings, for concert A and concert C
        double CONCERT_A = 440.0;

        for (int i = 0; i < keyboardString.length(); i++) {
            double frequency = CONCERT_A * Math.pow(2, ((i - 24) / (double) 12));

            obj[i] = new GuitarString(frequency);
        }

        int j;

        // the main input loop
        Keyboard keyboard = new Keyboard();
        while (true) {

            // check if the user has played a key; if so, process it
            if (keyboard.hasNextKeyPlayed()) {

                // the key the user played
                char key = keyboard.nextKeyPlayed();

                // pluck the corresponding string
                j = keyboardString.indexOf(key);

                if (j >= 0) {
                    obj[j].pluck();
                }

            }

            // compute the superposition of the samples
            double total = 0;

            for (int k = 0; k < keyboardString.length(); k++) {
                total = total + obj[k].sample();
            }

            // play the sample on standard audio
            StdAudio.play(total);

            // advance the simulation of each guitar string by one step
            for (int m = 0; m < keyboardString.length(); m++) {
                obj[m].tic();
            }
        }
    }
}
