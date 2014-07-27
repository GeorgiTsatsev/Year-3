function normalizeRGB = normalizeRGB(inimage) 
     R = inimage(:,:,1);
     G = inimage(:,:,2);
     B = inimage(:,:,3);

     NormalizedRed = R./sqrt(R.^2+G.^2+B.^2);
     NormalizedGreen = G./sqrt(R.^2+G.^2+B.^2);
     NormalizedBlue = B./sqrt(R.^2+G.^2+B.^2);

     outimage(:,:,1) = NormalizedRed;
     outimage(:,:,2) = NormalizedGreen;
     outimage(:,:,3) = NormalizedBlue;
     normalizeRGB=outimage;


