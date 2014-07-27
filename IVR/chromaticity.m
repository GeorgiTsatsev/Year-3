function [rgb] = chromaticity(RGB)
    R = RGB(:,:,1); % extract the red channel
    G = RGB(:,:,2); % extract the green channel
    B = RGB(:,:,3); % extract the blue channel
    V = R+G+B; % calculate summation of the 3 channels
    
    r = R./V; % calculate the red channel chromaticity
    g = G./V; % calculate the green channel chromaticity
    b = B./V; % calculate the blue channel chromaticity
    rgb = cat(3,r,g,b); %calculate the overall chromaticity
end
