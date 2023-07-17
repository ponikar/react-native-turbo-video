#ifdef RCT_NEW_ARCH_ENABLED
#import "TurboVideoView.h"

#import <react/renderer/components/RNTurboVideoViewSpec/ComponentDescriptors.h>
#import <react/renderer/components/RNTurboVideoViewSpec/EventEmitters.h>
#import <react/renderer/components/RNTurboVideoViewSpec/Props.h>
#import <react/renderer/components/RNTurboVideoViewSpec/RCTComponentViewHelpers.h>

#import "RCTFabricComponentsPlugins.h"
#import "Utils.h"

using namespace facebook::react;

@interface TurboVideoView () <RCTTurboVideoViewViewProtocol>

@end

@implementation TurboVideoView {
    UIView * _view;
}

+ (ComponentDescriptorProvider)componentDescriptorProvider
{
    return concreteComponentDescriptorProvider<TurboVideoViewComponentDescriptor>();
}

- (instancetype)initWithFrame:(CGRect)frame
{
  if (self = [super initWithFrame:frame]) {
    static const auto defaultProps = std::make_shared<const TurboVideoViewProps>();
    _props = defaultProps;

    _view = [[UIView alloc] init];

    self.contentView = _view;
  }

  return self;
}

- (void)updateProps:(Props::Shared const &)props oldProps:(Props::Shared const &)oldProps
{
    const auto &oldViewProps = *std::static_pointer_cast<TurboVideoViewProps const>(_props);
    const auto &newViewProps = *std::static_pointer_cast<TurboVideoViewProps const>(props);

    if (oldViewProps.color != newViewProps.color) {
        NSString * colorToConvert = [[NSString alloc] initWithUTF8String: newViewProps.color.c_str()];
        [_view setBackgroundColor: [Utils hexStringToColor:colorToConvert]];
    }

    [super updateProps:props oldProps:oldProps];
}

Class<RCTComponentViewProtocol> TurboVideoViewCls(void)
{
    return TurboVideoView.class;
}

@end
#endif
