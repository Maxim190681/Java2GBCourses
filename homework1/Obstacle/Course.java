package geekbrains.jmaxim1906.Java2.homework1.Obstacle;

import geekbrains.jmaxim1906.Java2.homework1.Participants.Participants;
import geekbrains.jmaxim1906.Java2.homework1.Participants.Team;

public class Course {
    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        Participants[] teamParticipants = team.getTeamParticipant();
        if (teamParticipants.length > 0) {
            for (Participants c: teamParticipants) {
                for (Obstacle o: obstacles) {
                    o.doIt(c);
                    if (!c.isOnDistance()) break;
                }
            }
        } else {
            System.out.println("В команде нет участников");
        }
    }
}
