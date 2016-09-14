#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
const int yue[12]={31,28,31,30,31,30,31,31,30,31,30,31};
class Date{
    private:
    int y,m,d;

    public:
    Date()
    {
        y=1900;
        m=1;
        d=1;
    }
    Date(int yy,int mm,int dd)
    {
        y=yy;
        m=mm;
        d=dd;
    }
    Date(const Date&p);
    friend ostream & operator<<(ostream &,const Date &);
    friend Date operator--(Date &,int);
    friend Date operator++(Date &,int);
    int getDate_y()const;
    int getDate_m()const;
    int getDate_d()const;
    Date add(int x);
    void setDate(int yy,int mm,int dd)
    {
        y=yy;
        m=mm;
        d=dd;
    }
    bool check()
    {
        if(y%4==0&&y%100!=0||y%400==0)
         return true;
        return false;
    }
    int jisuan()
    {
        int i,sum=d;
        for(i=0;i<m-1;i++)
        {
            sum+=yue[i];
        }
        if(m>2&&check())
        {
            sum++;
        }
        return sum;
    }
    Date nextDay()
    {
        Date n;
        int a=y,b=m,c=d;
        int *ly;
        memcpy(ly,yue,sizeof(yue));
        if(check())
        {
            ly[1]++;
        }
        if(ly[m-1]>c)
        {
            c++;
        }
        else
        {
            c=1;
            if(m==12)
            {
                b=1;
                a++;
            }
            else
            {
                b++;
            }
        }
        n.setDate(a,b,c);
        return n;
    }
};
Date::Date(const Date&p)
{
    y=p.getDate_y();
    m=p.getDate_m();
    d=p.getDate_d();
}
Date Date::add(int x)
{
    for(int i=0;i<x;i++)
     (*this)++;
     return *this;
}
int Date::getDate_y()const
{
  return y;
}
int Date::getDate_m()const
{
 return m;
}
int Date::getDate_d()const
{
    return d;
}
ostream & operator<<(ostream & output,const Date &x)
{
    output<<x.getDate_y()<<"Äê"<<x.getDate_m()<<"ÔÂ"<<x.getDate_d()<<"ÈÕ";

    return output;
}
Date operator--(Date &t,int)
{

     int a=t.getDate_y(),b=t.getDate_m(),c=t.getDate_d();
        int *ly;
        memcpy(ly,yue,sizeof(yue));
        if(t.check())
        {
            ly[1]++;
        }
        if(c>2)
        {
            c++;
        }
        else
        {
            if(b==1)
            {
                b=12;
                c=31;
                a--;
            }
            else
            {
                b--;
                c=ly[b-1];
            }
        }

        t.setDate(a,b,c);
        return t;
}
Date operator++(Date&t,int)
{
        int a=t.getDate_y(),b=t.getDate_m(),c=t.getDate_d();
        int *ly;
        memcpy(ly,yue,sizeof(yue));
        if(t.check())
        {
            ly[1]++;
        }
        if(ly[b-1]>c)
        {
            c++;
        }
        else
        {
            c=1;
            if(b==12)
            {
                b=1;
                a++;
            }
            else
            {
                b++;
            }
        }
        t.setDate(a,b,c);
        return t;
}
int main()
{
    int x,y,z;
    cin>>x>>y>>z;
    Date d(x,y,z);

    cout<<d<<endl;

    cout<<d.nextDay()<<endl;
    cout<<d.jisuan()<<endl;
    d--;
    cout<<d<<endl;
    d++;
    cout<<d<<endl;
    d.add(3);
    cout<<d<<endl;
    return 0;
}
