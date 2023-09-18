import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class test {

    static ArrayList<Article> articles = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lastId = 1;
        while(true){

            System.out.println("명령어 : ");
            String command = scan.nextLine();
            if(command.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if(command.equals("add")){
                System.out.println("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();
                System.out.println("게시물 내용을 입력해주세요: ");
                String content = scan.nextLine();
                Article article = new Article(lastId,title,content);
                articles.add(article);
                System.out.println("게시물이 등록되었습니다.");
                lastId++;
            } else if(command.equals("list")){
                System.out.println("===============");
                for(int i = 0 ; i < articles.size(); i++){
                    Article article = articles.get(i);
                    System.out.printf("번호 : %d\n",article.getCount());
                    System.out.printf("제목 : %s\n",article.getTitle());
                    System.out.println("==============");
                }
            } else if(command.equals("update")){
                System.out.println("수정할 게시물 번호 : ");
                int target = Integer.parseInt(scan.nextLine());
                boolean isExist = false;

                for(int i = 0; i < articles.size(); i++){
                    Article article = articles.get(i);
                    if(target == article.getCount()){
                    System.out.println("제목 : ");
                    String newTitle = scan.nextLine();
                    System.out.println("내용 : ");
                    String newContent = scan.nextLine();
                    Article newArticle = new Article(target,newTitle,newContent);
                    articles.set(i,newArticle);
                        System.out.printf("%d번 게시물이 수정되었습니다.",article.getCount());
                    isExist = true;
                    }
                    System.out.println(" ");
                }
                if(isExist == false) {
                    System.out.println("없는 게시물 번호입니다.");

                }
            } else if (command.equals("delete")) {
                System.out.println("삭제할 게시물 번호 : ");
                int target = Integer.parseInt(scan.nextLine());
                boolean isExist = false;

                for(int i = 0; i < articles.size(); i++){
                    Article article = articles.get(i);
                    if(target == article.getCount()){
                        articles.remove(i);
                        System.out.printf("%d번 게시물이 삭제되었습니다.\n",article.getCount());
                        isExist = true;
                    }
                }
                if(isExist == false){
                    System.out.println("없는 번호");
                }
            } else if (command.equals("detail")) {
                System.out.println("상세보기 할 게시물 번호를 입력해 주세요 : ");
                int target = Integer.parseInt(scan.nextLine());
                boolean isExist = false;
                for(int i = 0; i < articles.size(); i++){
                    Article article = articles.get(i);
                    if(target == article.getCount()){
                        System.out.printf("번호 : %d\n" , article.getCount());
                        System.out.printf("제목 : %s\n" , article.getTitle()) ;
                        System.out.printf("내용 : %s\n" , article.getContent()) ;
                        isExist = true;
                    }
                }
                if(isExist == false){
                    System.out.println("존재하지 않는 게시물 번호입니다.");
                }
            }
        }
    }

}
