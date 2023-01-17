package com.tpov.collator

import java.text.Collator
import java.text.ParseException
import java.text.RuleBasedCollator
import java.util.Locale

class MyCollatorProvider {
    private var charLaters: Array<Char> = arrayOf('A', 'a')

    val availableLocales: Array<Locale>
        get() = arrayOf(
            Locale("en", "EN")
        )

    fun firstOrNull(fullName: String): Char? {
        for (i in charLaters.indices) {
            return if (fullName[0] == charLaters[i]) charLaters[i]
            else null
        }
        return null
    }

    fun getInstanceUaRu(): Collator {
        val rules = StringBuilder()

        rules.append("& А,а < Б,б < В,в < Г,г < Ґ,ґ < Д,д < Е,е < э,Э < ё,Ё < Є,є < Ж,ж < З,з < И,и")
        rules.append("& И,и < Ы,ы < І,і < Ї,ї < Й,й < К,к < Л,л < М,м < Н,н < О,о < П,п < Р,р < С,с")
        rules.append("& С,с < Т,т < У,у < Ф,ф < Х,х < Ц,ц < Ч,ч < Ш,ш < Щ,щ < Ю,ю < Я,я")

        return try {
            RuleBasedCollator(rules.toString())
        } catch (pe: ParseException) {
            throw Error(pe)
        }
    }

    fun getInstanceUaRuAndEn(): Collator {
        val rules = StringBuilder()

        rules.append("& А,а < Б,б < В,в < Г,г < Ґ,ґ < Д,д < Е,е < э,Э < ё,Ё < Є,є < Ж,ж < З,з < И,и")
        rules.append("& И,и < Ы,ы < І,і < Ї,ї < Й,й < К,к < Л,л < М,м < Н,н < О,о < П,п < Р,р < С,с")
        rules.append("& С,с < Т,т < У,у < Ф,ф < Х,х < Ц,ц < Ч,ч < Ш,ш < Щ,щ < Ю,ю < Я,я")

        rules.append("& я,Я < A,a < B,b < C,c < D,d < E,e < F,f < G,g < H,h < I,i < J,j < K,k < L,l")
        rules.append("& L,l < M,m < N,n < O,o < P,p < Q,q < R,r < S,s < T,t < U,u < V,v < W,w < X,x")
        rules.append("& X,x < Y,y < Z,z < 0 < 1 < 2 < 3 < 3 < 4 < 5 < 6 < 7 < 8 < 9 < + < ! < @ < #")
        rules.append("& # < $ < % < ^ < & < * < ( < ) < - < =< + < / < ? < | < ; < : < ` < ~")

        return try {
            RuleBasedCollator(rules.toString())
        } catch (pe: ParseException) {
            throw Error(pe)
        }
    }

    fun getInstanceUaRuEn(): Collator {
        val rules = StringBuilder()

        rules.append("& А,а < \u0061,\u0041 < Б,б < b,B < В,в < v,V < w,W < Г,г < h,H < Ґ,ґ < g,G")
        rules.append("& g,G < Д,д < d,D < Е,е < э,Э < ё,Ё < e,E < Є,є < ie,Ye < Ж,ж < zh,Zh < З,з")
        rules.append("& З,з < z,Z < И,и < y,Y < Ы,ы< І,і < i,I < E,e < Ї,ї < Yi,yi < Й,й < k,K < К,к")
        rules.append("& К,к < l,L < Л,л < m,M < М,м < n,N < Н,н < o,O < О,о < p,P < q,Q < П,п < r,R")
        rules.append("& r,R < Р,р < s,S < С,с < C,c < t,T < Т,т < u,U < У,у < f,F < Ф,ф < kh,Kh < Х,х")
        rules.append("& Х,х < ts,Ts < Ц,ц < ch,Ch < Ч,ч < sh,Sh < Ш,ш < shch,Shch < Щ,щ < yu,Yu < ь,Ь")
        rules.append("& ь,Ь < Ъ,ъ < Ю,ю < ya,Ya < Я,я")
        rules.append("& Дж,дж < j,J")
        rules.append("& Кс,кс < x,X")

        return try {
            RuleBasedCollator(rules.toString())
        } catch (pe: ParseException) {
            throw Error(pe)
        }
    }
}
