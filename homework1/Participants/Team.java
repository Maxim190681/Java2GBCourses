package geekbrains.jmaxim1906.Java2.homework1.Participants;

public class Team {
    String teamName;
    Participants[] teamParticipant = new Participants[4];

    public Team(String teamName, Participants[] teamParticipant) {
        this.teamName = teamName;
        this.teamParticipant = teamParticipant;
    }
    public String getTeamName() {
        return "Имя команды: " + teamName;
    }
    public Participants[] getTeamParticipant() {
        return teamParticipant;
    }
    public void showResults() {
        for (Participants c: teamParticipant) {
            c.showResult();
        }
    }
    public void showParticipantFinishedCourse() {
        for (Participants c: teamParticipant) {
            if (c.isOnDistance())
                c.showResult();
        }
    }
}
