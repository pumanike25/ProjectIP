import java.util.ArrayList;
import java.util.List;

public class Tube {
    private List<Sphere> spheres;

    public Tube() {
        spheres = new ArrayList<>();
    }

    public void addSphere(Sphere sphere) {
        spheres.add(sphere);
    }

    public Sphere removeSphere() {
        if (!spheres.isEmpty()) {
            return spheres.remove(spheres.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return spheres.isEmpty();
    }

    // Verifică dacă toate bilele din tub sunt de aceeași culoare
    public boolean isSorted() {
        if (spheres.isEmpty()) {
            return true;
        }
        
        String firstColor = spheres.get(0).getColor();
        for (Sphere sphere : spheres) {
            if (!sphere.getColor().equals(firstColor)) {
                return false;  // dacă există bile de culori diferite
            }
        }
        return true;
    }

    public String getTopColor() {
        if (!spheres.isEmpty()) {
            return spheres.get(spheres.size() - 1).getColor();
        }
        return null;
    }

    public List<Sphere> getSpheres() {
        return spheres;
    }
}
