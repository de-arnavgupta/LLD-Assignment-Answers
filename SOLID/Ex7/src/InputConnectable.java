// for devices that accept an input source (HDMI, VGA, etc.)
public interface InputConnectable extends SmartClassroomDevice {
    void connectInput(String port);
}
