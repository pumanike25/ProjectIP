public class MoveSphereCommand {
    private Tube fromTube;
    private Tube toTube;
    private Sphere sphere;

    public MoveSphereCommand(Tube fromTube, Tube toTube) {
        this.fromTube = fromTube;
        this.toTube = toTube;
    }

    public void execute() {
        sphere = fromTube.removeSphere();
        if (sphere != null) {
            toTube.addSphere(sphere);
        }
    }
}
