package CM;

public class CM35 {
    public int calc(int a, int b, int type) {
        int r = 0;
        switch(type){
            case 1: r = mult(a,b); break;
            case 0: r = div(a,b); break;
            case -1: r = sub(a,b); break;
        }
        return r;
    }

    //乘法
    public int mult(int a,int b){
        int r = 0;
        for(int i = 0;i<a;i++)
            r += b;
        return r;
    }

    //除法
    public int div(int a,int b){
        for(int i = 1;i<=a;i++)
            if(mult(b,i) <= a && mult(b,i+1) > a)
                return i;
        return 0;
    }

    //减法
    public int sub(int a,int b){
        if(a>=b)
            for(int i = 0;i<a;i++)
                if(i+b == a)
                    return i;
        return mult(sub(b,a),-1);
    }
}
