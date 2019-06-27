package example.administrator.a2019_openhack_team22;

import android.animation.Animator;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.text.NumberFormat;

public class AwardActivity extends AppCompatActivity {

    Boolean isWin = true;   // Intent getExtra로 처리
    LottieAnimationView lottieAnimationView;
    TextView txtResult;     // true면 ㅊㅋ, false면 다음에는 열심히...
    TextView txtRank;       // setText 할 때
    ConstraintLayout layoutCost;    // 돈 결과 나오는 레이아웃
    TextView txtWinnerUserName; // 우승한 유저 이름
    TextView txtAmount;     // setText 할 때 "원"붙여줘야함

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_award);
        lottieAnimationView = findViewById(R.id.lottie);

        txtResult = findViewById(R.id.txt_result);
        txtRank = findViewById(R.id.txt_rank);
        txtWinnerUserName = findViewById(R.id.txt_winner_name);
        txtAmount = findViewById(R.id.txt_cost);
        layoutCost = findViewById(R.id.layout_cost);

        if(isWin){
            lottieAnimationView.setAnimation("677-trophy.json");
            txtResult.setText("축하합니다!");
            txtRank.setText("우승");
            // TODO: 유저네임 받아야함
            txtAmount.setText(NumberFormat.getInstance().format(19000) + "원");
        }
        else{
            lottieAnimationView.setAnimation("6627-dislike-thumb-emoji.json");
            txtResult.setText("다음엔 돈을\n조금만 걸어보세요...!");
            txtRank.setText("실패");
            // TODO: 유저네임 받아야함
            txtAmount.setText(NumberFormat.getInstance().format(-19000) + "원");
        }
        // lottie 애니메이션 실행
        lottieAnimationView.playAnimation();


        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                // TODO: fade-out 애니메이션 필요
                lottieAnimationView.setVisibility(View.GONE);
                txtResult.setVisibility(View.VISIBLE);
                txtRank.setVisibility(View.VISIBLE);
                txtWinnerUserName.setVisibility(View.VISIBLE);
                txtResult.setVisibility(View.VISIBLE);
                layoutCost.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animator) {
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }
}
