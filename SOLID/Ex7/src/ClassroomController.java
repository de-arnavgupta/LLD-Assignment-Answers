public class ClassroomController {
    private final DeviceRegistry reg;

    public ClassroomController(DeviceRegistry reg) { this.reg = reg; }

    public void startClass() {
        // turn on projector and connect HDMI
        InputConnectable projInput = reg.getFirst(InputConnectable.class);
        ((Switchable) projInput).powerOn();
        projInput.connectInput("HDMI-1");

        // dim lights and set AC
        reg.getFirst(BrightnessControllable.class).setBrightness(60);
        reg.getFirst(TemperatureControllable.class).setTemperatureC(24);

        // take attendance
        System.out.println("Attendance scanned: present=" + reg.getFirst(Scannable.class).scanAttendance());
    }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        // switch off everything that has a power button
        for (Switchable s : reg.getAll(Switchable.class)) {
            s.powerOff();
        }
    }
}
