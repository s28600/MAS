package s28600_MP3.Dynamic;

public class User {
    private String nickname;
    private AccessType accessType;

    public User(String nickname, AccessType accessType) {
        setNickname(nickname);
        setAccessType(accessType);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        if (nickname == null || nickname.isBlank())
            throw new IllegalArgumentException("Nickname cannot be null or empty");
        this.nickname = nickname;
    }

    public AccessType getAccessType() {
        return accessType;
    }

    public void setAccessType(AccessType accessType) {
        if (accessType == null)
            throw new IllegalArgumentException("Access type cannot be null");
        this.accessType = accessType;
    }

    public void register(){
        if (accessType != AccessType.guest)
            throw new UnsupportedOperationException("You are already registered");
        System.out.println("Registered as " + getNickname());
    }

    public void leaveReview(){
        if (accessType != AccessType.loggedUser)
            throw new UnsupportedOperationException("You can't leave review if you are not logged or logged in as an administrator");
        System.out.println("Left review as " + getNickname());
    }

    public void banUser(){
        if (accessType != AccessType.admin)
            throw new UnsupportedOperationException("You can't ban user if you are not logged in as an administrator");
        System.out.println("Banned user");
    }
}
