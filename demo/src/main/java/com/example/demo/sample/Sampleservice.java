package com.example.demo.sample;

import org.springframework.stereotype.Service;

@Service
public class Sampleservice {
int add(int num1,int num2)
{
    return num1+num2;
}
int sub(int num1,int num2)
{
    return num1-num2;
}
double mul(Serviceobject s)
{
    return s.getNum1()*s.getNum2();
}

double div(Serviceobject d)
{
    return d.getNum1()/d.getNum2();
}
}
