private class ConnectivityNetworkCallback extends ConnectivityManager.NetworkCallback {
        @Override
        public void onAvailable(@NonNull Network network) {
            mNetwork = network;
            mNetworkCapabilities = getConnectivityManager().getNetworkCapabilities(network);
            onNetworkUpdate();
        }

        @Override
        public void onLosing(@NonNull Network network, int maxMsToLive) {
            mNetwork = network;
            mNetworkCapabilities = getConnectivityManager().getNetworkCapabilities(network);
            onNetworkUpdate();
        }

        @Override
        public void onLost(@NonNull Network network) {
            mNetwork = null;
            mNetworkCapabilities = null;
            onNetworkUpdate();
        }

        @Override
        public void onUnavailable() {
            mNetwork = null;
            mNetworkCapabilities = null;
            onNetworkUpdate();
        }

        @Override
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            mNetwork = network;
            mNetworkCapabilities = networkCapabilities;
            onNetworkUpdate();
        }

        @Override
        public void onLinkPropertiesChanged(@NonNull Network network, @NonNull LinkProperties linkProperties) {
            if (mNetwork != null) {
                mNetwork = network;
                mNetworkCapabilities = getConnectivityManager().getNetworkCapabilities(network);
                onNetworkUpdate();
            }
        }
    }
