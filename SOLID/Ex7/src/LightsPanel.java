// lights can be switched on/off and dimmed
public class LightsPanel implements Switchable, BrightnessControllable {
    @Override public void powerOn() { /* always on */ }
    @Override public void powerOff() { System.out.println("Lights OFF"); }
    @Override public void setBrightness(int pct) { System.out.println("Lights set to " + pct + "%"); }
}
