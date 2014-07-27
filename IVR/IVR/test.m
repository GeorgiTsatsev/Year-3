function test = test(A) 
	cform = makecform('srgb2lab');
	original = A;
% A first pass at noise reduction using a median filter, operating plane-by-plane:
for ii = 1:3
    original(:,:,ii) = medfilt2(original(:,:,ii),[6 6]);
end
%lab = applycform(original,cform);

% Now we're going to threshold the "a*" colorspace:
%a = lab(:,:,2);
%original = im2bw(a,0.5);
test=original;
imshow(test)
