import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Animals {
    private String idNumber;
    private String name;
    private float maximumSpeed;
    private String breed;
    private String type;
    private String cry;

    public Animals(String name, String type, String cry) {
        this.name= name;
        this.type=type;
        this.cry=cry;

    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber=idNumber;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name=name;
    }

    public float getMaximumSpeed() {
        return maximumSpeed;
    }
    public void setMaximumSpeed(float maximumSpeed) {
        this.maximumSpeed=maximumSpeed;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed= breed;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type=type;
    }
    public String getCry() {
        return cry;
    }
    public void setCry(String cry) {
        this.cry=cry;
    }
   public void scream() {
        try {
            System.out.println("Initialisation du cri...");

            File file = new File(this.cry);

            AudioInputStream original =
                    AudioSystem.getAudioInputStream(file);

            AudioFormat audioFormat = getAudioFormat(original);

            AudioInputStream converted = AudioSystem.getAudioInputStream(audioFormat, original);

            Clip clip = AudioSystem.getClip();
            clip.open(converted);
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 1000);

            clip.close();
            converted.close();
            System.out.println("Fin de cri !");
        }catch (Exception e) {
            System.out.println("Fichier indisponible");
        }
   }

    private static AudioFormat getAudioFormat(AudioInputStream original) {
        AudioFormat sourceFormat= original.getFormat();

        return new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED,
                sourceFormat.getSampleRate(),
                16,
                sourceFormat.getChannels(),
                sourceFormat.getChannels()* 2,
                sourceFormat.getSampleRate(),
                false
        );
    }
}

