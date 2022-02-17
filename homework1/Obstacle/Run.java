package geekbrains.jmaxim1906.Java2.homework1.Obstacle;

import geekbrains.jmaxim1906.Java2.homework1.Participants.Participants;

public class Run extends Obstacle {
    private int distance;

    public Run(int distance) {
        this.distance = distance;
    }
    public void doIt(Participants participants) {
        participants.run(distance);
    }
}
