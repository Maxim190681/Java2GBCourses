package geekbrains.jmaxim1906.Java2.homework1.Participants;

public abstract class Animal implements Participants {
    String type;
    String name;
    int maxRunDistance;
    int maxJumpDistance;
    int maxSwimDistance;
    boolean onDistance;

    public boolean isOnDistance() {
        return onDistance;
    }

    public Animal(String type, String name, int maxRunDistance, int maxJumpDistance, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpDistance = maxJumpDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    public void run(int distance) {
        if(distance <= maxRunDistance) {
            System.out.println(type + " " + name + " " + " справился с  бегом!");
        } else {
            System.out.println(type + " " + name + " " + " не смог пробежать");
            onDistance = false;
        }
    }

    public void jump(int distance) {
        if(distance <= maxJumpDistance) {
            System.out.println(type + " " + name + " " + " справился с прыжком!");
        } else {
            System.out.println(type + " " + name + " " + " не смог прыгнуть");
        }
    }

    public void swim (int distance) {
        if (maxSwimDistance == 0) {
            System.out.println(type + " " + name + " " + " не умеет плавать");
            onDistance = false;
            return;
        }
        if (distance <= maxSwimDistance) {
            System.out.println(type + " " + name + " " + " справился с  плаванием");
        } else {
            System.out.println(type + " " + name + " " + " не смог проплыть");
            onDistance = false;
        }
    }

    public void showResult() {
        System.out.println(type + " " + name + ": " + onDistance);
    }
}
