public class CrossfadeActivity extends Activity {

  private View mContentView;
  private View mLoadingView;
  private int mShortAnimationDuration;
  
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_crossfade);
    
    mContentView = findViewById(R.id.content);
    mLoadingView = findViewById(R.id.loading_snipper);
    
    mContentView.setVisibility(View.GONE);
    
    mShortAnimationDuration = getResources().getInteger(android.R.integer.config_shortAnimTime);
    
    private void crossfade() {

      mContentView.setAlpha(0f);
      mContentView.setVisibility(View.VISIBLE);
      
      mContentView.animate()
        .alpha(1f)
        .setDuration(mShortAnimationDuration)
        .setListener(null);
      
      mLoadingView.animate()
        .alpha(0f)
        .setDuration(mShortAnimationDuration)
        .setListener(new AnimatorListenerAdapter() {
          @Override
          public void onAnimationEnd(Animator animator){
            mLoadingView.setVisibility(View.GONE);
          }
        });
    }
}    
