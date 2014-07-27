(****************************************************************************)
header {* Propositional Logic in Isabelle *}
(****************************************************************************)

theory Prop
imports Main

begin

(****************************************************************************)
section {* Introduction *}

text {* This Isabelle theory file accompanies Lectures 2-4 of the
        Automated Reasoning course. By stepping through it
        using an Isabelle front-end such as Proof General, you should
        become familiar with how to undertake propositional logic
        proofs in Isabelle. *}

(****************************************************************************)
section {* First theorems *}

theorem K: "A \<longrightarrow> B \<longrightarrow> A"
apply (rule impI)
apply (rule impI)
apply assumption
done

text {* The \texttt{rule impI} and \texttt{assumption} above are examples of
        Isabelle \emph{proof methods}.

         After processing \texttt{done} above, the front-end will
        display a version of the theorem with the A and B replaced by
        ?A and ?B.  These are \emph{schematic} or \emph{meta}
        variables that can be freely instantiated if theorem K is used
        in some further proof.

        Theorems can involve assumptions from the start.  For example,
        here is the Isabelle version of the natural deduction
        derivation from the end of Lecture 2.*}

theorem a_conj_theorem: "\<lbrakk> A ; B \<rbrakk> \<Longrightarrow> A \<and> (B \<and> A)"
apply (rule conjI)
apply assumption
apply (rule conjI)
apply assumption 
apply assumption
done 

text {* We can add {\tt +} to the end of a method in order to apply it
        more than once. We can also use the keyword {\tt by} instead
        of {\tt apply} for the final line of the proof. This allows us
        to discard the {\tt done}.  So, the same theorem can be proved
        as follows: *}


theorem a_conj_theorem2: "\<lbrakk> A ; B \<rbrakk> \<Longrightarrow> A \<and> (B \<and> A)"
apply (rule conjI)
apply assumption
apply (rule conjI)
by assumption+

(****************************************************************************)
section {* More On Applying Rules *}


text {* In Lecture 3 we proved {\tt B} $\lor$ {\tt A} from the assumption
        {\tt A} $\lor$ {\tt B}. In Isabelle, this lemma can be proved as 
        follows:
      *}   

lemma "A \<or> B \<Longrightarrow> B \<or> A"
apply (erule disjE)
apply (rule disjI2)
apply assumption
apply (rule disjI1)
by assumption

text {* It is instructive to see what happens when we apply a rule
        backward such that not all of its variables can be immediately
        instantiated.  Look at what happens below after {\tt rule
        disjE}.  We get schematic variables in both subgoals that then
        are instantiated once we apply the assumption method on the
        1st subgoal.  *}

lemma "A \<or> B \<Longrightarrow> B \<or> A"
apply (rule disjE)
apply assumption
apply (rule disjI2)
apply assumption
apply (rule disjI1)
by assumption


(****************************************************************************)
section {* More Methods *}

text {* Isabelle also provides the methods {\tt drule} and {\tt frule} for
        forwards reasoning. These are best used with destruction rules. For
        example:
      *}

lemma "A \<and> B \<Longrightarrow> A"
apply (drule conjunct1)
by assumption 

lemma "A \<and> B \<Longrightarrow> A"
apply (frule conjunct1)
by assumption


(****************************************************************************)
section {* Problems Revisited *}

text{* We can now return to the three problems first posed in Lecture
       2.  The written proof of Example 1 is shown in Lecture 3. Its
       equivalent Isabelle proof is: *}
   
lemma example1: "(SunnyTomorrow \<or> RainyTomorrow) \<and> \<not>SunnyTomorrow 
                  \<longrightarrow> RainyTomorrow" 
apply (rule impI)
apply (erule conjE)
apply (erule disjE)
apply (erule notE)
by assumption+

text{* The proofs of Examples 2 and 3 are: *}

lemma example2: "(Class \<or> Pop) \<and> (Class \<longrightarrow> Soph) \<and> \<not>Pop \<longrightarrow> Soph"
apply (rule impI)
apply (erule conjE)+
apply (erule disjE)
apply (erule impE)
apply assumption+
apply (erule notE)
by assumption


lemma example3: "(M \<or> L) \<and> (M \<or> W) \<and> \<not>(L \<and> W) \<longrightarrow> M \<or> (M \<and> L) \<or> (M \<and> W)" 
apply (rule impI)
apply (erule conjE)+
apply (erule disjE)
apply (erule disjE)
apply (rule disjI1)
apply assumption
apply (rule disjI1)
apply assumption
apply (erule disjE)
apply (rule disjI1)
apply assumption
apply (erule notE)
apply (rule conjI)
by assumption+

(*****************************************************************************)
section {* Applying Rules to Correct Assumptions *}

text {* Consider the following lemma and proof: *}

lemma conj_elim1: "\<lbrakk> A \<and> B; C \<and> D \<rbrakk> \<Longrightarrow> D" 
apply (erule conjE)
apply (erule conjE)
by assumption

text {* Notice that in this proof we had to apply the rule {\tt conjE} 
        twice in order to
        eliminate the conjunction in the second assumption. We could have
        avoided writing the extra proof step by using {\tt +}:
      *}  

lemma conj_elim2: "\<lbrakk> A \<and> B; C \<and> D \<rbrakk> \<Longrightarrow> D"
apply (erule conjE)+
by assumption

text {* Although this new proof is shorter, we have still carried out an 
       unnecessary step: we do not need to eliminate the 
       conjunction in the first assumption. If we want to apply {\tt conjE} 
       to a an assumption different from the first one it matches, then
       we can rotate the ordering of our assumptions. To do this Isabelle 
       provides a tactic called {\tt rotate\_tac}. An alternative proof is 
       thus: 
     *}  

lemma conj_elim3: "\<lbrakk> A \<and> B; C \<and> D \<rbrakk> \<Longrightarrow> D"
apply (rotate_tac 1)
apply (erule conjE)
by assumption

text {* If our list of assumptions is very large, we may not want to use
       {\tt rotate\_tac}. A better approach is to explicitly tell Isabelle
       what instantiations the variables in a rule should take when we apply 
       it. To do this we use the methods {\tt rule\_tac}, {\tt erule\_tac},
       {\tt drule\_tac} and {\tt frule\_tac}. Our alternative proof of
       {\tt conj\_elim} is:
    *}     

lemma conj_elim4: "\<lbrakk> A \<and> B; C \<and> D \<rbrakk> \<Longrightarrow> D"
apply (erule_tac P=C and Q=D in conjE)
by assumption

text {* In the above proof it is not neccessary to tell Isabelle the variable
        {\tt Q} in the rule {\tt conjE} should be instantiated to {\tt D}. 
        Isabelle can automatically infer this! So our proof becomes:
      *}  

lemma conj_elim5: "\<lbrakk> A \<and> B; C \<and> D \<rbrakk> \<Longrightarrow> D"
apply (erule_tac P=C in conjE)
by assumption

(*****************************************************************************)
section{* More Rules of the Game *}

text {* If you start proving a lemma but get stuck, you can always
        type the command {\tt oops} to abandon the proof. For example:
      *}  

lemma A_and_B_imp_B_or_A: "A \<and> B \<longrightarrow> B \<or> A"
oops

text {* Now imagine we want to use {\tt A\_and\_B\_imp\_B\_or\_A} to prove
        later lemmas and theorems. As it is not a rule (since it does
        not have the $\Longrightarrow$) we use it by inserting it as an 
        assumption in our proof. This is done using
        a tactic called {\tt cut\_tac}. Consider the following lemma and 
        try uncommenting the {\tt apply} command.
      *} 

lemma "A \<and> B \<Longrightarrow> B \<or> A"
(* apply (cut_tac A_and_B_imp_B_or_A) *)
(* Isabelle complains! *)
oops

text {*  When we try to insert {\tt A\_and\_B\_imp\_B\_or\_A} into our proof
         Isabelle complains. This is because Isabelle does not know
         the theorem. The command {\tt oops} allowed us to abandon our 
         proof, but it also told Isabelle to forget the lemma completely. 

         To allow Isabelle to continue checking this theory, comment out
         again the {\tt apply} command above.

         Instead of using {\tt oops}, we could have used the command 
         {\tt sorry}:
      *}
          
lemma A_and_B_imp_B_or_A_take2: "A \<and> B \<longrightarrow> B \<or> A"
sorry

text {* The command {\tt sorry} tells Isabelle to abandon the proof
        but pretend that the lemma has been proved. This allows us to use it
        in later proofs: 
      *}   

lemma cut_in_action: "A \<and> B \<Longrightarrow> B \<or> A"
apply (cut_tac A_and_B_imp_B_or_A_take2) 
apply (erule impE)
apply assumption+
done

text {* A word of warning: {\tt sorry} is a cheat allowing you to make 
        progress. You should return to the incomplete proof and finish it
        to be completely sure the rest of your theory is valid.
      *}

(*****************************************************************************)
section {* Automation *}

text{* It may seem tedious having to type in all these commands. Isabelle does
       provide some automation. The tactics {\tt simp} and {\tt auto} both
       use the classical reasoner of Isabelle and can make life a lot easier.
       Example:
     *} 

lemma proved_by_simp: "A \<and> B \<Longrightarrow> B \<or> A"
by simp 

lemma proved_by_auto: "A \<and> B \<Longrightarrow> B \<or> A"
by auto


end






