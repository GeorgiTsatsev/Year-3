function rgb = normalize(RGB)
	R = RGB(:,:,1); 
	G = RGB(:,:,2);
	B = RGB(:,:,3);
	sum = R+G+B;
    
    	h = R./sum; 
    	s = G./sum;
    	v = B./sum; 
	rgb = cat(3,R,G,B); 

