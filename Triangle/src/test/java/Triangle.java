public class Triangle {
    int a;
    int b;
    int c;
    public Triangle(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
    public boolean judgeTriangle(){
        boolean resulet =true;
        if(a==0||b==0||c==0){
            resulet=false;
            return resulet;
        }
        if(a+b<=c){
            resulet=false;
            return resulet;
        }
        if(a+c<=b){
            resulet=false;
            return resulet;
        }
        if(b+c<=a){
            resulet=false;
            return resulet;
        }
        return resulet;
    }
}
