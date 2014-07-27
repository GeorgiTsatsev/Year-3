(*****************************************************************************)

(*<*)
theory Assignment
imports Main Fact "~~/src/HOL/Hoare/Hoare_Logic"
begin
(*>*)

(*****************************************************************************)

(* Please write your matriculation number here: *)
(* Matric: s1045049  *)

(*****************************************************************************)

(* Part 1: Natural Deduction (40 marks *)
(* Replace "oops" with your proof. *)

lemma shows "P \<longrightarrow> P"
apply (rule impI)
apply assumption
done
(* 1 mark *)


lemma shows "P \<and> Q \<longrightarrow> Q \<and> P"
apply (rule impI)
apply (rule conjI)
apply (rule conjunct2)
apply assumption
apply (rule conjunct1)
apply assumption
done
(* 1 mark *)


lemma shows "P \<or> Q \<longrightarrow> Q \<or> P"
apply (rule impI)
apply (rule disjE)
apply assumption
apply (rule disjI2)
apply assumption
apply (rule disjI1)
apply assumption
done

(* 1 mark *)


lemma shows "(Q \<and> R) \<and> P \<longrightarrow> (P \<and> R) \<and> Q"
apply (rule impI)
apply (erule conjE)
apply (erule conjE)
apply (rule conjI)
apply (rule conjI)
apply assumption
apply assumption
apply assumption
done
(* 2 marks *)


lemma shows "A \<Longrightarrow> (B \<and> C) \<and> D \<Longrightarrow> E \<longrightarrow> F \<longrightarrow> D \<and> A \<and> C"
apply (rule impI)
apply (rule impI)
apply (erule conjE)
apply (erule conjE)
apply (rule conjI)
apply assumption
apply (rule conjI)
apply assumption
apply assumption
done
(* 2 marks *)


lemma shows "(A \<longrightarrow> B) \<and> (C \<longrightarrow> D) \<and> (A \<or> C) \<longrightarrow> B \<or> D"
apply (rule impI)
apply (erule conjE)
apply (erule conjE)
apply (erule disjE)
apply (erule impE)
apply assumption
apply (rule disjI1)
apply assumption
apply (erule impE)
back
apply assumption
apply (rule disjI2)
apply assumption
done
(* 2 marks *)


lemma shows "(Q \<or> R) \<and> P \<longrightarrow> \<not>P \<longrightarrow> Q"
apply (rule impI)
apply (rule impI)
apply (erule conjE)
apply (erule notE)
apply assumption
done
(* 3 marks *)


lemma shows "(\<not>P \<longrightarrow> Q) \<longrightarrow> (\<not>P \<longrightarrow> \<not>Q) \<longrightarrow> P"
apply (rule impI)
apply (rule impI)
apply (rule ccontr)
apply (erule impE)
apply assumption
apply (erule impE)
apply assumption
apply (erule notE)
apply (erule notE)
apply assumption
done 
(* 3 marks *)


lemma shows "\<not>(P \<and> Q) \<longrightarrow> \<not>P \<or> \<not>Q"
apply (rule impI)
apply (rule ccontr)
apply (erule notE)
apply (rule conjI)
apply (rule ccontr)
apply (erule notE)
apply (rule disjI1)
apply assumption
apply (rule ccontr)
apply (erule notE)
apply (rule disjI2)
apply assumption
done
(* 4 marks *)


lemma shows "(\<forall>x y. R x y) \<longrightarrow> (\<forall>x. R x x)"
apply (rule impI)
apply (rule allI)
apply (erule allE)
apply (erule allE)
apply assumption
done
(* 3 marks *)


lemma shows "(\<forall> x. P x \<longrightarrow> Q x) \<longrightarrow> \<not> (\<exists> x. P x \<and> \<not> Q x)"
apply (rule impI)
apply (rule notI)
apply (erule exE)
apply (erule conjE)
apply (erule_tac x="x" in allE)
apply (erule impE)
apply assumption
apply (erule notE)
apply assumption
done
(* 4 marks *)


lemma shows "(\<exists> x. \<forall> y. P x y) \<longrightarrow> (\<forall> y. \<exists> x. P x y)"
apply (rule impI)
apply (rule allI)
apply (erule exE)
apply (erule_tac x="y"in allE)
apply (rule_tac x="x" in exI)
apply assumption
done 
(* 4 marks *)


lemma shows "\<not> (\<exists> barber. man barber \<and> (\<forall> x. man x \<and> \<not>shaves x x \<longleftrightarrow> shaves barber x ))"
apply (rule notI)
apply (erule exE)
apply (erule conjE)
apply (erule_tac x="barber" in  allE)
apply (erule iffE)
apply (erule impE)
apply (rule conjI)
apply assumption
apply (rule notI)
apply (erule impE)
apply assumption
apply (erule conjE)
apply (erule notE)
apply assumption
apply (erule impE)
apply assumption
apply (erule conjE)
apply (erule notE)
apply assumption
done
(* 5 marks *) 


lemma shows "(\<forall> (x :: int). (\<exists> y. P x y) \<longrightarrow> Q x) \<and> (\<forall> R (x :: int) y . R x y \<longrightarrow> R y x) \<longrightarrow> (\<forall> z . P a z \<longrightarrow> Q z)"
apply (rule impI)
apply (erule conjE)
apply (rule allI)
apply (rule impI)
apply (erule_tac x="P" in allE)
apply (erule_tac x="z" in allE)
apply (erule_tac x="a" in allE)
apply (erule_tac x="z" in allE)
apply (erule impE)
apply (erule impE)
apply assumption
apply (rule_tac x="a"in exI)
apply assumption
apply assumption
done
(* 5 marks *)


(*****************************************************************************)

(* Part 2: Software verification using Hoare logic (60 marks) *)

(*---------------------------------------------------------------------------*)

(* Some simple algorithms (15 marks) *)

  (* The minimum of two integers x and y: *)
lemma Min: "VARS (z :: int)
 {True}
 IF x \<le> y THEN z := x ELSE z := y FI
  { z = min x y }"
apply vcg_simp
apply (rule conjI)
apply (rule impI)
apply  simp
apply (rule impI)
apply simp
done
(* 1 mark *)


(* Iteratively copy an integer variable x to y: *)
lemma Copy: "VARS (a :: int) y
 {0 \<le> x}
 a := x; y := 0;
 WHILE a \<noteq> 0
 INV { x=y+a } 
 DO y := y + 1 ; a := a - 1 OD
 {x = y}"
-- "Replace Inv with your invariant."
apply vcg_simp
done
(* 2 marks *)


(* Iterative multiplication through addition: *)
lemma Multi1: "VARS (a :: int) z
 {0 \<le> y}
 a := 0; z := 0;
 WHILE a \<noteq> y
 INV { z=x*a }
 DO 
   z := z + x ; 
   a := a + 1 
 OD
 {z = x * y}"
-- "Replace Inv with your invariant."
apply vcg_simp
apply (erule conjE)
--" applying simplification rule to remove the brackets and prove the lemma." 
apply (simp add: distrib_right algebra_simps)
done
(* 2 marks *)


(* Alternative multiplication algorithm: *)
lemma Multi2: "VARS (z :: int) y
 {y = y0 \<and> 0 \<le> y}
 z := 0;
 WHILE y \<noteq> 0
 INV { z=(y0-y)*x }
 DO 
   z := z + x; 
   y := y - 1 
 OD
 {z = x * y0}"
-- "Replace Inv with your invariant."
apply vcg_simp
apply (erule conjE)
-- "applying simplification rule to remove the brackets (left associative since it is subtraction inside the brackets"
apply (simp add:distrib_left  algebra_simps)
done
(* 2 marks *)


(* A factorial algorithm: *)
lemma DownFact: "VARS (z :: nat) (y::nat)
 {True}
 z := x; y := 1;
 WHILE z > 0
 INV {fact x = y * fact z }
 DO 
   y := y * z; 
   z := z - 1 
 OD
 {y = fact x}"
-- "Replace Inv with your invariant."
apply vcg_simp
apply (erule conjE)
apply (rule disjI2)
apply (simp add: fact_reduce_nat) 
done
(* 3 marks *)


(* Integer division of x by y: *)
lemma Div: "VARS (r :: int) d 
 {y \<noteq> 0}
 r := x; d := 0;
 WHILE y \<le> r
 INV { r=x-(y*d) }
 DO 
  r := r - y;
  d := d + 1
 OD
 { x= (x div y )* y + x mod y}"
-- "Replace Inv with your invariant."
-- "Replace Postcondition with your postcondition."
apply vcg_simp
apply (erule conjE)
apply (simp add:distrib_left  algebra_simps)
done
(* 5 marks *)


(*---------------------------------------------------------------------------*)

(* Minimal sum section (45 marks) *)


(*------------------------ Do NOT edit this section -------------------------*)

(* Sum of a section: *)
fun sectsum :: "int list \<Rightarrow> nat \<Rightarrow> nat \<Rightarrow> int" where
"sectsum l i j = listsum (take (j - i + 1) (drop i l))"

(* Loop invariants: *)
fun Inv1 :: "int list \<Rightarrow> int \<Rightarrow> nat \<Rightarrow> bool" where
"Inv1 l s k = (\<forall> i j . (0 \<le> i \<and> i \<le> j \<and> j < k \<longrightarrow> s \<le> sectsum l i j))"

fun Inv2 :: "int list \<Rightarrow> int \<Rightarrow> nat \<Rightarrow> bool" where
"Inv2 l t k = (\<forall> i . (0 \<le> i \<and> i < k \<longrightarrow> t \<le> sectsum l i (k - 1)))"

(*---------------------------------------------------------------------------*)

(* Specification S1 (25 marks) *)
(* Replace "oops" with your proof. *)

-- "This is a helper lemma that is used to prove the inequality transitivity. since I could not find a way to prove it with the syntax given I used the sorry command. Although the logic is obvious."

lemma transitivity: "i<k\<longrightarrow> i <= j \<and> j<k"
apply (rule impI)
sorry 

lemma lemma4_20a: "\<lbrakk> k < length A ; Inv1 A s k ; Inv2 A t k \<rbrakk> \<Longrightarrow> 
  Inv2 A (min (A!k) (t + (A!k))) (Suc k)"
apply auto
apply (erule_tac x="i" in allE)
apply (erule_tac x="i" in allE)
apply (erule_tac x="j" in allE)
apply (erule impE)
apply (erule impE)
apply (insert transitivity)
apply auto
done


lemma lemma4_20b: "\<lbrakk> k < length A ; Inv1 A s k ; Inv2 A t k \<rbrakk> \<Longrightarrow> 
  Inv1 A (min s (min (A!k) (t + (A!k)))) (Suc k)"
apply auto
apply (erule_tac x="i" in allE)
apply (erule_tac x="i" in allE)
apply (erule_tac x="j" in allE)
apply (erule impE)
apply (erule impE)
apply (insert transitivity)
apply auto
done

lemma MinSum: "VARS k (t :: int) s
 {0 < length A}
 k := 1;
 t := (A!0);
 s := (A!0);
 WHILE k < length A
 INV { Inv1 A s k \<and> Inv2 A t k }
 DO
 IF (A!k) \<le> t + (A!k)  THEN t := (A!k)  ELSE t := t + (A!k)  FI;
 IF t \<le> s  THEN s := t  ELSE SKIP  FI;
 k := Suc k 
 OD
 {Inv1 A s (length A)}"
apply vcg_simp
apply (case_tac A, simp, simp)
apply auto
apply (erule_tac x="i"in allE)
apply (erule_tac x="i"in allE)
apply (erule_tac x="j"in allE)
apply (erule impE)
apply (erule impE)
apply (insert transitivity)
apply auto
apply (erule_tac x="i"in allE)
apply (erule_tac x="i"in allE)
apply (erule_tac x="j"in allE)
apply (erule impE)
apply (erule impE)
apply (insert transitivity)
apply auto
apply (erule_tac x="i"in allE)
apply (erule_tac x="i"in allE)
apply (erule_tac x="j"in allE)
apply (erule impE)
apply (erule impE)
apply (insert transitivity)
apply auto
apply (erule_tac x="i"in allE)
apply (erule_tac x="i"in allE)
apply (erule_tac x="j"in allE)
apply (erule impE)
apply (erule impE)
apply (insert transitivity)
apply auto
apply (erule_tac x="i"in allE)
apply (erule_tac x="i"in allE)
apply (erule_tac x="j"in allE)
apply (erule impE)
apply (erule impE)
apply (insert transitivity)
apply auto
apply (erule_tac x="i"in allE)
apply (erule_tac x="i"in allE)
apply (erule_tac x="j"in allE)
apply (erule impE)
apply (erule impE)
apply (insert transitivity)
apply auto
apply (erule_tac x="i"in allE)
apply (erule_tac x="i"in allE)
apply (erule_tac x="j"in allE)
apply (erule impE)
apply (erule impE)
apply (insert transitivity)
apply auto
apply (erule_tac x="i"in allE)
apply (erule_tac x="i"in allE)
apply (erule_tac x="j"in allE)
apply (erule impE)
apply (erule impE)
apply (insert transitivity)
apply auto

done

(*---------------------------------------------------------------------------*)

(* Specification S2 (20 marks) *)
(* Replace "oops" with your proof. *) 

lemma MinSum2: "VARS k (t :: int) s
 {length A > 0}
 k := 1;
 t := (A!0);
 s := (A!0);
 WHILE k < length A
 INV {  Inv1 A s k \<and> Inv2 A t k \<and> (\<exists> i j . (0 \<le> i \<and> i \<le> j \<and> j < k \<and> s = sectsum A i j)) }
 DO
 IF (A!k) \<le> t + (A!k)  THEN t := (A!k)  ELSE t := t + (A!k)  FI;
 IF t \<le> s  THEN s := t  ELSE SKIP  FI;
 k := Suc k 
 OD
 {(\<exists> i j . (0 \<le> i \<and> i \<le> j \<and> j < length A \<and> s = sectsum A i j))}"
-- "Replace Inv with your invariant."
apply vcg_simp
apply (case_tac A, simp, simp)
apply (erule conjE)
apply (erule conjE)
apply (erule conjE)
apply (erule exE)
apply (erule exE)
apply (erule_tac x="i"in allE)
apply (erule_tac x="i"in allE)
apply (erule_tac x="j"in allE)
apply (rule conjI)
apply (rule impI)
apply (rule conjI)
apply (rule impI)
apply (rule conjI)
apply (insert transitivity)
apply force
apply blast
apply blast
apply blast
apply blast 
-- "The rules that were proven by blast were similar to the previous rules that have been proven. That is why I have used the blast tool."

done

(*****************************************************************************)

end

(*****************************************************************************)




