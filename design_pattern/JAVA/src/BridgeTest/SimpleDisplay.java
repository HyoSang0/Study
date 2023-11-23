package BridgeTest;

public class SimpleDisplay implements Display{

    @Override
    public void title(Draft draft) {
        System.out.println(draft.getTitle());
    }

    @Override
    public void author(Draft draft) {
        System.out.println(draft.getAuthor());
    }

    @Override
    public void content(Draft draft) {
        String[] content = draft.getContent();
        for(String cnt : content)
            System.out.println(cnt);
    }
    
}
